#include <security/pam_appl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <pwd.h>
#include <grp.h>
#include <unistd.h>

// Define the conv function
int conv(int num_msg, const struct pam_message **msg, struct pam_response **resp, void *appdata_ptr) {
    struct pam_response *aresp = malloc(num_msg * sizeof(struct pam_response));

    for (int i = 0; i < num_msg; i++) {
        aresp[i].resp_retcode = 0;

        if (msg[i]->msg_style == PAM_PROMPT_ECHO_OFF) {
            // Prompt the user for a password
            aresp[i].resp = malloc(PAM_MAX_RESP_SIZE);
            if (fgets(aresp[i].resp, PAM_MAX_RESP_SIZE, stdin) == NULL) {
                aresp[i].resp_retcode = 1;
            } else {
                // Remove the newline character
                aresp[i].resp[strcspn(aresp[i].resp, "\n")] = 0;
            }
        } else if (msg[i]->msg_style == PAM_PROMPT_ECHO_ON) {
            // Prompt the user for a username
            aresp[i].resp = malloc(PAM_MAX_RESP_SIZE);
            if (fgets(aresp[i].resp, PAM_MAX_RESP_SIZE, stdin) == NULL) {
                aresp[i].resp_retcode = 1;
            } else {
                // Remove the newline character
                aresp[i].resp[strcspn(aresp[i].resp, "\n")] = 0;
            }
        } else {
            aresp[i].resp = NULL;
        }
    }

    *resp = aresp;
    return PAM_SUCCESS;
}

static struct pam_conv pam_conversation = { conv, NULL };

pam_handle_t *try_login(const char *service, int *retval) {
    static char *username = NULL;
    pam_handle_t *pamh;

    *retval = pam_start(service, username, &pam_conversation, &pamh);

    if (*retval == PAM_SUCCESS) *retval = pam_authenticate(pamh, 0);
    if (*retval == PAM_SUCCESS) *retval = pam_acct_mgmt(pamh, 0);
    if (*retval == PAM_SUCCESS) *retval = pam_open_session(pamh, 0);

    if (username == NULL) {
        if (pam_get_item(pamh, PAM_USER, (const void **) &username) == PAM_SUCCESS) {
            username = strdup(username);
        }
    }

    if (*retval != PAM_SUCCESS) {
        fprintf(stderr, "%s: %s\n", service, pam_strerror(pamh, *retval));
        pam_end(pamh, *retval);
        pamh = NULL;
    }

    return pamh;
}

int check_group_membership(const char *user, const char *group) {
    struct passwd *pw = getpwnam(user);
    if (pw == NULL) {
        perror("getpwnam");
        return -1;
    }

    int ngroups = 0;
    getgrouplist(user, pw->pw_gid, NULL, &ngroups);
    gid_t *groups = malloc(ngroups * sizeof(gid_t));
    getgrouplist(user, pw->pw_gid, groups, &ngroups);

    struct group *gr;
    for (int i = 0; i < ngroups; i++) {
        gr = getgrgid(groups[i]);
        if (gr && strcmp(gr->gr_name, group) == 0) {
            free(groups);
            return 1; // User is in the group
        }
    }

    free(groups);
    return 0; // User is not in the group
}

int main(void) {
    pam_handle_t *pamh = NULL;
    int retval;
    const char *username;

    pamh = try_login("pamdemo", &retval);

    if (!pamh) {
        fprintf(stderr, "Access denied.\n");
        return 1;
    }

    pam_get_item(pamh, PAM_USER, (const void **) &username);

    int is_admin = check_group_membership(username, "admin");
    int is_operator = check_group_membership(username, "operator");

    if (is_admin > 0) {
        printf("Logged in as %s with admin privileges.\n", username);
    } else if (is_operator > 0) {
        printf("Logged in as %s with operator privileges.\n", username);
    } else {
        printf("Logged in as %s with no special privileges.\n", username);
    }

    pam_close_session(pamh, 0);
    pam_end(pamh, retval);

    return 0;
}