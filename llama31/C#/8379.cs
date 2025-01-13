public static ulong Fnv1aHash(string input)\n{\n    const ulong prime = 0x100000001b3; // 1099511628211\n    const ulong offsetBasis = 0xcbf29ce484222325; // 14695981039346656037\n\n    ulong hash = offsetBasis;\n    foreach (char c in input)\n    {\n        hash = (hash ^ c) * prime;\n    }\n\n    return hash;\n}