#include <security/pam_appl.h>\n#include <stdio.h>\n#include <string.h>\n#include <stdlib.h>\n#include <pwd.h>\n#include <grp.h>\n#include <unistd.h>\n\nstatic struct pam_conv pam_conversation = { conv, NULL };\n\npam_handle_t *try_login(const char *service, int *retval)\n{\n    static char *username = NULL;\n    pam_handle_t *pamh;\n\n    *retval = pam_start(service, username, &pam_conversation, &pamh);\n\n    if (*retval == PAM_SUCCESS) *retval = pam_authenticate(pamh, 0);\n    if (*retval == PAM_SUCCESS) *retval = pam_acct_mgmt(pamh, 0);\n    if (*retval == PAM_SUCCESS) *retval = pam_open_session(pamh, 0);\n\n    if (username == NULL) {\n        if (pam_get_item(pamh, PAM_USER, (const void **) &username) == PAM_SUCCESS) {\n            username = strdup(username);\n        }\n    }\n\n    if (*retval != PAM_SUCCESS) {\n        fprintf(stderr, "%s: %s\n", service, pam_strerror(pamh, *retval));\n        pam_end(pamh, *retval);\n        pamh = NULL;\n    }\n\n    return pamh;\n}\n\nint check_group_membership(const char *user, const char *group)\n{\n    struct passwd *pw = getpwnam(user);\n    if (pw == NULL) {\n        perror("getpwnam");\n        return -1;\n    }\n\n    int ngroups = 0;\n    getgrouplist(user, pw->pw_gid, NULL, &ngroups);\n    gid_t *groups = malloc(ngroups * sizeof(gid_t));\n    getgrouplist(user, pw->pw_gid, groups, &ngroups);\n\n    struct group *gr;\n    for (int i = 0; i < ngroups; i++) {\n        gr = getgrgid(groups[i]);\n        if (gr && strcmp(gr->gr_name, group) == 0) {\n            free(groups);\n            return 1; // User is in the group\n        }\n    }\n\n    free(groups);\n    return 0; // User is not in the group\n}\n\nint main(void)\n{\n    pam_handle_t *pamh = NULL;\n    int retval;\n    const char *username;\n\n    pamh = try_login("pamdemo", &retval);\n\n    if (!pamh) {\n        fprintf(stderr, "Access denied.\n");\n        return 1;\n    }\n\n    pam_get_item(pamh, PAM_USER, (const void **) &username);\n\n    int is_admin = check_group_membership(username, "admin");\n    int is_operator = check_group_membership(username, "operator");\n\n    if (is_admin > 0) {\n        printf("Logged in as %s with admin privileges.\n", username);\n    } else if (is_operator > 0) {\n        printf("Logged in as %s with operator privileges.\n", username);\n    } else {\n        printf("Logged in as %s with no special privileges.\n", username);\n    }\n\n    pam_close_session(pamh, 0);\n    pam_end(pamh, retval);\n\n    return 0;\n}