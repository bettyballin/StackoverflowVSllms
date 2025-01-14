#include <ldap.h>

int main() {
    LDAP *ld;

    // Initialize the LDAP connection
    if (ldap_initialize(&ld, "ldap://localhost") != LDAP_SUCCESS) {
        return 1;
    }

    // Set the reconnect option
    ldap_set_option(ld, LDAP_OPT_RECONNECT, LDAP_OPT_ON);

    // Clean up
    ldap_unbind_ext_s(ld, NULL, NULL);

    return 0;
}