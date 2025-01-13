using System;\nusing System.Text;\n\npublic class StringTrimmer\n{\n    public static string TrimUtf8Bytes(string input, int maxLengthInBytes)\n    {\n        if (string.IsNullOrEmpty(input) || maxLengthInBytes <= 0)\n            return string.Empty;\n\n        var encoding = Encoding.UTF8;\n        byte[] encodedBytes = encoding.GetBytes(input);\n\n        if (encodedBytes.Length <= maxLengthInBytes)\n            return input;\n\n        // Find the position to trim\n        int trimmedLength = 0;\n        for (int i = 0; trimmedLength < maxLengthInBytes && i < input.Length; i++)\n        {\n            char c = input[i];\n            int size = encoding.GetByteCount(new char[] { c });\n            if (trimmedLength + size <= maxLengthInBytes)\n                trimmedLength += size;\n            else\n                break;\n        }\n\n        return input.Substring(0, trimmedLength);\n    }\n}