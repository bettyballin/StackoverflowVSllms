bool CharIsHex(char c) {\n    return Uri.IsWellFormedUriString(new string(c, 1), UriKind.Absolute);\n}