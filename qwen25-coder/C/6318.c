if (enet_initialize () != 0)\n{\n    fprintf(stderr, "An error occurred while initializing ENet.\n");\n    return EXITSUCCESS;\n}\natexit(enet_deinitialize);