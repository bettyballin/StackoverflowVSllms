using System;\nusing System.IO;\nusing System.Text;\n\npublic static string ConvertToAscii(byte[] inputBytes)\n{\n    // Automatically detect the encoding and read all bytes from the input array.\n    var detectedEncoding = Encoding.UTF8; // Default to UTF-8, adjust if necessary\n    try\n    {\n        using (var memoryStream = new MemoryStream(inputBytes))\n        {\n            var preambleSize = Encoding.UTF8.GetPreamble().Length;\n            byte[] possibleBom = new byte[preambleSize];\n            if (memoryStream.Read(possibleBom, 0, preambleSize) != preambleSize)\n                throw new ArgumentException("Input is too small to contain a BOM");\n\n            // Check for UTF-16 LE/BE BOMs and adjust encoding\n            if (Encoding.BigEndianUnicode.GetPreamble().SequenceEqual(possibleBom))\n            {\n                detectedEncoding = Encoding.BigEndianUnicode;\n            }\n            else if (Encoding.Unicode.GetPreamble().SequenceEqual(possibleBom.PadLeftOrTruncate(preambleSize)))\n            {\n                detectedEncoding = Encoding.Unicode; // Little Endian\n            }\n\n            memoryStream.Position = 0; // Rewind to beginning for reading with detected encoding.\n        }\n    }\n    catch { /* Assume the input doesn't have a discernible BOM, use default encoding as fallback. */ }\n\n    string originalString = detectedEncoding.GetString(inputBytes);\n    \n    // Convert using ASCII and replace non-ASCII characters (you could also choose to ignore them)\n    byte[] asciiBytes = Encoding.ASCII.GetBytes(originalString.Where(c => c < 128).ToArray());\n    \n    return Encoding.ASCII.GetString(asciiBytes);\n}\n\npublic static class Extensions\n{\n    public static byte[] PadLeftOrTruncate(this byte[] array, int length)\n    {\n        if (array.Length >= length) return array.Take(length).ToArray();\n        var newArray = new byte[length];\n        Array.Copy(array, 0, newArray, length - array.Length, array.Length);\n        return newArray;\n    }\n}