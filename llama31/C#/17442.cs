using HashidsNet;\n\npublic static string GuidToHashid(Guid guid)\n{\n    var hashids = new Hashids("your salt", 8); // 8 characters long\n    var bytes = guid.ToByteArray();\n    var number = BitConverter.ToInt64(bytes, 0);\n    return hashids.Encode(number);\n}