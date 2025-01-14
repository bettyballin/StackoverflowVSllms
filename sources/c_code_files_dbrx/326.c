#include <dc1394/dc1394.h>
#include <inttypes.h>

int main() {
    dc1394_t *camera;
    uint64_t format;
    dc1394bool_t is_formats;
    uint32_t *data;
    int num;

    // Initialize the camera
    camera = dc1394_new();

    // Get mode setting. Feature selector depends on your specific camera, see documentation for that.
    dc1394_feature_get(camera, DC1394_FEATURE_MODE_0);

    // Decode format
    dc1394_format7_decode(&format, NULL, NULL, NULL, NULL, &is_formats, data, num);

    return 0;
}