#include <stdio.h>\n#include <stdlib.h>\n#include <signal.h>\n#include <mqueue.h>\n\nmqd_t mq_descriptor;\nconst char *mq_name = "/my_message_queue";\n\nvoid cleanup() {\n    mq_close(mq_descriptor);\n    mq_unlink(mq_name);  // Unlinks the queue from filesystem\n}\n\n// Signal handler for catching critical signals like SIGINT, SIGTERM.\nvoid sig_handler(int signum) {\n    printf("Signal %d received. Cleaning...\n", signum);\n    cleanup();\n    exit(EXIT_SUCCESS);\n}\n\nint main() {\n    struct mq_attr attr;\n    attr.mq_flags = 0;\n    attr.mq_maxmsg = 10;    // Adjust queue parameters as needed\n    attr.mq_msgsize = 256;\n    attr.mq_curmsgs = 0;\n\n    mq_descriptor = mq_open(mq_name, O_CREAT | O_RDWR, 0644, &attr);\n    if (mq_descriptor == -1) {\n        perror("mq_open");\n        exit(EXIT_FAILURE);\n    }\n\n    // Register the cleanup function to be called on normal exit\n    atexit(cleanup);\n\n    // Set up signal handlers for critical signals\n    struct sigaction sa;\n    sa.sa_handler = sig_handler;\n    sigemptyset(&sa.sa_mask);\n    sa.sa_flags = 0;\n\n    if (sigaction(SIGINT, &sa, NULL) == -1 || \n        sigaction(SIGTERM, &sa, NULL) == -1 ||\n        sigaction(SIGHUP, &sa, NULL) == -1 ||\n        sigaction(SIGQUIT, &sa, NULL) == -1) {\n        perror("sigaction");\n        cleanup();\n        exit(EXIT_FAILURE);\n    }\n\n    // Your main application logic here\n    while (1) { /* Example infinite loop simulating work */ }\n\n    return 0;\n}