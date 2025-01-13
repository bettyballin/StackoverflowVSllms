bool DoesWildcardMatch(string wildcard);\n\nstring BruteForceString() {\n    string charset = "abcdefghijklmnopqrstuvwxyz0123456789"; // Add special characters if needed\n    string result = "";\n    int length = 1;\n\n    // Determine the length of the string\n    while (DoesWildcardMatch(new string('?', length))) {\n        length++;\n    }\n    length--; // Adjust for overshoot\n\n    // Determine the character set (optional optimization)\n    string detectedCharset = "";\n    for (char ch : charset) {\n        if (DoesWildcardMatch("*" + ch + "*")) {\n            detectedCharset += ch;\n        }\n    }\n\n    // Determine each character in the string\n    for (int i = 0; i < length; i++) {\n        int low = 0;\n        int high = detectedCharset.length() - 1;\n\n        while (low <= high) {\n            int mid = (low + high) / 2;\n            char midChar = detectedCharset[mid];\n            string testWildcard = result + midChar + new string('?', length - i - 1);\n\n            if (DoesWildcardMatch(testWildcard + "*")) {\n                result += midChar;\n                break;\n            } else {\n                // Adjust the search range\n                if (DoesWildcardMatch(result + "[" + detectedCharset.Substring(0, mid) + "]" + new string('?', length - i - 1) + "*")) {\n                    high = mid - 1;\n                } else {\n                    low = mid + 1;\n                }\n            }\n        }\n    }\n\n    return result;\n}