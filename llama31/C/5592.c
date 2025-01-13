// Virus definition for EICAR test virus\nchar eicar_signature[] = "X5O!P%@AP[4\PKZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*";\n\n// Heuristic function to detect suspicious patterns\nint detect_suspicious_pattern(char *file_contents) {\n    // Simplified example: check for presence of suspicious strings\n    if (strstr(file_contents, "X5O!P%@AP[4") != NULL) {\n        return 1; // Suspicious pattern detected\n    }\n    return 0;\n}\n\n// Antivirus program's scanning function\nvoid scan_file(char *file_contents) {\n    // Check against virus definitions\n    if (strcmp(file_contents, eicar_signature) == 0) {\n        printf("EICAR test virus detected!\n");\n    } else {\n        // Check using heuristics\n        if (detect_suspicious_pattern(file_contents) == 1) {\n            printf("Suspicious object detected!\n");\n            // Take action (e.g., delete file)\n        }\n    }\n}