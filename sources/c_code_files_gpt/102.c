#include <libcryptsetup.h>
#include <stdio.h>

int main() {
    struct crypt_device *cd;
    const char *device_path = "/dev/sdX"; // Replace with your device path
    const char *passphrase = "yourpassphrase"; // Replace with your passphrase

    if (crypt_init(&cd, device_path) < 0) {
        fprintf(stderr, "crypt_init() failed\n");
        return 1;
    }

    if (crypt_load(cd, CRYPT_LUKS1, NULL) < 0) {
        fprintf(stderr, "crypt_load() failed\n");
        crypt_free(cd);
        return 1;
    }

    if (crypt_activate_by_passphrase(cd, "luks", CRYPT_ANY_SLOT, passphrase, strlen(passphrase), 0) < 0) {
        fprintf(stderr, "crypt_activate_by_passphrase() failed\n");
        crypt_free(cd);
        return 1;
    }

    printf("Encrypted device activated successfully\n");

    crypt_free(cd);
    return 0;
}