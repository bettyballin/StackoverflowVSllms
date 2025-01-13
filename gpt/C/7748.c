#include <libcryptsetup.h>\n#include <stdio.h>\n\nint main() {\n    struct crypt_device *cd;\n    const char *device_path = "/dev/sdX"; // Replace with your device path\n    const char *passphrase = "yourpassphrase"; // Replace with your passphrase\n\n    if (crypt_init(&cd, device_path) < 0) {\n        fprintf(stderr, "crypt_init() failed\n");\n        return 1;\n    }\n\n    if (crypt_load(cd, CRYPT_LUKS1, NULL) < 0) {\n        fprintf(stderr, "crypt_load() failed\n");\n        crypt_free(cd);\n        return 1;\n    }\n\n    if (crypt_activate_by_passphrase(cd, "luks", CRYPT_ANY_SLOT, passphrase, strlen(passphrase), 0) < 0) {\n        fprintf(stderr, "crypt_activate_by_passphrase() failed\n");\n        crypt_free(cd);\n        return 1;\n    }\n\n    printf("Encrypted device activated successfully\n");\n\n    crypt_free(cd);\n    return 0;\n}