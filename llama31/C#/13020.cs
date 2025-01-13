using System;\nusing System.IO;\nusing System.IO.Compression;\nusing System.Text;\n\npublic class HtmlCompressor\n{\n    public static string CompressHtml(string html)\n    {\n        var bytes = Encoding.UTF8.GetBytes(html);\n        using (var ms = new MemoryStream())\n        {\n            using (var gzip = new GZipStream(ms, CompressionMode.Compress))\n            {\n                gzip.Write(bytes, 0, bytes.Length);\n            }\n            return Convert.ToBase64String(ms.ToArray());\n        }\n    }\n\n    public static string DecompressHtml(string compressedHtml)\n    {\n        var bytes = Convert.FromBase64String(compressedHtml);\n        using (var ms = new MemoryStream(bytes))\n        {\n            using (var gzip = new GZipStream(ms, CompressionMode.Decompress))\n            {\n                using (var reader = new StreamReader(gzip))\n                {\n                    return reader.ReadToEnd();\n                }\n            }\n        }\n    }\n}