using System.IO.Compression;\n   \n   public static byte[] Compress(byte[] data)\n   {\n       MemoryStream output = new MemoryStream();\n       using (DeflateStream gzip = new DeflateStream(output, CompressionLevel.Optimal))\n       {\n           gzip.Write(data, 0, data.Length);\n       }\n       return output.ToArray();\n   }