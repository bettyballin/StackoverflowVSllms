// OpenH264 example\n#include <openh264/decoder.h>\n\nint main() {\n    // Initialize decoder\n    decoder_t* decoder = decoder_create();\n\n    // Decode frame\n    uint8_t* frame = ...; // frame data\n    int frame_size = ...; // frame size\n    decoder_decode(decoder, frame, frame_size);\n\n    // Release decoder\n    decoder_destroy(decoder);\n    return 0;\n}