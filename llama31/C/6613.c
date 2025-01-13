// Example code in C\n#include <libfprint/fprint.h>\n\nint main() {\n    // Initialize the library\n    fp_init();\n\n    // Open the fingerprint reader device\n    fp_dev *dev = fp_open("/dev/bus/usb/001/002");\n\n    // Capture a fingerprint image\n    fp_img *img = fp_capture(dev);\n\n    // Process the image\n    fp_print_data *data = fp_img_to_print_data(img);\n\n    // Do something with the fingerprint data\n    // ...\n\n    // Clean up\n    fp_close(dev);\n    fp_exit();\n    return 0;\n}