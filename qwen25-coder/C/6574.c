dc1394video_frame_t *frame;\n   frame = dc1394_capture_dequeue(framegrabber, DC1394_CAPTURE_POLICY_WAIT);\n   printf("Frame size: %dx%d\n", frame->size[0], frame->size[1]);