// Vulnerable code\nvoid vulnerable_function(char *input) {\n    char buffer[10];\n    strcpy(buffer, input);\n}\n\n// Malicious input\nchar malicious_input[] = "AAAAAAAAAA\x12\x34\x56\x78"; // overwrite return address\n\n// Inject malicious code\nvulnerable_function(malicious_input);