public static string GuidToBase62(Guid guid)\n{\n    var bytes = guid.ToByteArray();\n    var base62 = Convert.ToBase62(BitConverter.ToInt64(bytes, 0));\n    return base62.Substring(0, 8); // take the first 8 characters\n}\n\npublic static string Convert.ToBase62(long value)\n{\n    const string base62Chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";\n    var result = "";\n    while (value > 0)\n    {\n        result = base62Chars[(int)(value % 62)] + result;\n        value /= 62;\n    }\n    return result;\n}