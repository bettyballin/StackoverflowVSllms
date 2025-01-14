#include <dc1394/dc1394.h>
#include <stdio.h> // Add this line to include the standard input/output library

int main() {
    dc1394_t *d;
    dc1394camera_t *camera;
    dc1394video_modes_t video_modes;
    dc1394video_mode_t current_video_mode;

    d = dc1394_new();
    // Replace YOUR_CAMERA_GUID with the actual GUID of your camera
    camera = dc1394_camera_new(d, 0); // Assuming the camera GUID is 0

    if (!camera) {
        fprintf(stderr, "Failed to initialize camera\n");
        return 1;
    }

    dc1394_video_get_supported_modes(camera, &video_modes);

    // Set to YUV422 mode
    dc1394_video_set_mode(camera, DC1394_VIDEO_MODE_640x480_YUV422);
    dc1394_video_get_mode(camera, &current_video_mode);

    printf("Current video mode: %d\n", current_video_mode);

    // Capture and inspect frame
    dc1394_capture_setup(camera, 4, DC1394_CAPTURE_FLAGS_DEFAULT);
    dc1394_video_set_transmission(camera, DC1394_ON);

    dc1394video_frame_t *frame;
    dc1394_capture_dequeue(camera, DC1394_CAPTURE_POLICY_WAIT, &frame);

    if (frame->size[0] != 640 || frame->size[1] != 480 || frame->total_bytes != 640 * 480 * 2) {
        printf("Frame size mismatch: width=%d, height=%d, total_bytes=%d\n",
               frame->size[0], frame->size[1], frame->total_bytes);
    }

    dc1394_capture_enqueue(camera, frame);
    dc1394_video_set_transmission(camera, DC1394_OFF);
    dc1394_capture_stop(camera);
    dc1394_camera_free(camera);
    dc1394_free(d);

    return 0;
}