public static double JaroWinklerDistance(string s1, string s2)\n{\n    const double threshold = 0.7;\n    const double prefixScale = 0.1;\n\n    int len1 = s1.Length;\n    int len2 = s2.Length;\n\n    if (len1 == 0 && len2 == 0) return 1.0;\n\n    int maxLen = Math.Max(len1, len2);\n    double matchRange = Math.Floor(maxLen / 2.0) - 1;\n\n    int[] flags1 = new int[len1];\n    int[] flags2 = new int[len2];\n\n    int matches = 0;\n    int transpositions = 0;\n\n    for (int i = 0; i < len1; i++)\n    {\n        int low = Math.Max(0, i - (int)matchRange);\n        int high = Math.Min(i + (int)matchRange, len2 - 1);\n\n        for (int j = low; j <= high; j++)\n        {\n            if (s1[i] == s2[j] && flags2[j] == 0)\n            {\n                flags1[i] = 1;\n                flags2[j] = 1;\n                matches++;\n                break;\n            }\n        }\n    }\n\n    if (matches == 0) return 0.0;\n\n    for (int i = 0; i < len1; i++)\n    {\n        if (flags1[i] == 1)\n        {\n            int j;\n            for (j = i; j < len1; j++)\n            {\n                if (flags1[j] == 0) break;\n            }\n            if (j > i)\n            {\n                transpositions += j - i - 1;\n                i = j - 1;\n            }\n        }\n    }\n\n    double similarity = (matches / (double)maxLen) + (matches - transpositions / 2.0) / (double)matches;\n    double prefix = 0.0;\n\n    for (int i = 0; i < Math.Min(4, len1); i++)\n    {\n        if (s1[i] == s2[i]) prefix++;\n        else break;\n    }\n\n    return similarity + prefix * prefixScale * (1 - similarity);\n}