// Set the video mode to DC1394_VIDEO_MODE_640x480_YUV422\ndc1394_video_set_mode(camera, DC1394_VIDEO_MODE_640x480_YUV422);\n\n// Get the current video mode\ndc1394video_mode_t current_mode;\ndc1394_video_get_mode(camera, &current_mode);\n\n// Check if the current mode is actually YUV422\nif (current_mode != DC1394_VIDEO_MODE_640x480_YUV422) {\n    // Try setting the video mode again, this time with the IIDC v1.30 compliant flag\n    dc1394_video_set_mode(camera, DC1394_VIDEO_MODE_640x480_YUV422 | DC1394_VIDEO_MODE_FORMAT7);\n}