// Simplified example for setting up seccomp filter\n#include <seccomp.h>\n#include <unistd.h>\n\nvoid setup_seccomp() {\n    scmp_filter_ctx ctx;\n    ctx = seccomp_init(SCMP_ACT_KILL);\n    if (!ctx) return;\n\n    // Allow necessary system calls\n    seccomp_rule_add(ctx, SCMP_ACT_ALLOW, SCMP_SYS(read), 0);\n    seccomp_rule_add(ctx, SCMP_ACT_ALLOW, SCMP_SYS(write), 0);\n\n    // Load the filter into kernel space\n    if (seccomp_load(ctx) < 0) {\n        seccomp_release(ctx);\n        return;\n    }\n}\n\nint main() {\n    setup_seccomp();\n    // Rest of the code\n}