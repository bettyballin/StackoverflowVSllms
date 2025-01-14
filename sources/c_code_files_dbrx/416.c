#include <security/pam_appl.h>
#include <security/pam_modules.h>

// ...

// After successful authentication with one service
const void *data;
pam_get_item(handle, PAM_AUTHTOK, &data);

if (pam_setcred(handle, PAM_ESTABLISH_CRED) != PAM_SUCCESS) {
    pam_error(handle, "Error saving password via keyring");
} else {
    // Save the username for later retrieval of auth token via keyid from pam service name pair.
    const char *username = "userX"; // Retrieve it from actual authentication step.
}

// ...