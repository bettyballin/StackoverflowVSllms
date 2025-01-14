#include <stdio.h>
#include <dc1394/dc1394.h>

int main() {
    dc1394_t *dc1394;
    dc1394camera_t *camera;
    dc1394video_frame_t *frame;

    // Initialize the library
    dc1394 = dc1394_new();

    // Get the camera
    camera = dc1394_camera_new(dc1394, 0);

    // Dequeue a frame
    dc1394_capture_dequeue(camera, DC1394_CAPTURE_POLICY_WAIT, &frame);

    if (frame->size[0] != 640 || frame->size[1] != 480 || frame->total_bytes != 640 * 480 * 2) {
        printf("Frame size mismatch: width=%d, height=%d, total_bytes=%d\n",
               frame->size[0], frame->size[1], frame->total_bytes);
    }

    // Enqueue the frame
    dc1394_capture_enqueue(camera, frame);

    // Clean up
    dc1394_camera_free(camera);
    dc1394_destroy(dc1394);

    return 0;
}