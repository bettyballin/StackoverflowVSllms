#include <procfs.h>\n#include <stdio.h>\n\nint main() {\n    int fd;\n    struct ps_prochandle *P;\n    struct psinfo psi;\n\n    // Open the /proc directory\n    fd = open("/proc", O_RDONLY);\n    if (fd < 0) {\n        perror("open");\n        return 1;\n    }\n\n    // Create a process handle\n    P = proc_open(fd, NULL, 0);\n    if (P == NULL) {\n        close(fd);\n        perror("proc_open");\n        return 1;\n    }\n\n    // Get process info for the current process\n    if (proc_get_psinfo(P, &psi) == -1) {\n        proc_close(P);\n        close(fd);\n        perror("proc_get_psinfo");\n        return 1;\n    }\n\n    // Print process info\n    printf("PID: %d\n", psi.pr_pid);\n    printf("Name: %s\n", psi.pr_fname);\n    printf("Status: %c\n", psi.pr_stat);\n\n    // Close the process handle and /proc directory\n    proc_close(P);\n    close(fd);\n\n    return 0;\n}