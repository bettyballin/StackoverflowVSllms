private void Copy(string srcFile, string dstFile, int offset, int length)\n{\n    using (var srcStream = File.OpenRead(srcFile))\n    {\n        srcStream.Seek(offset, SeekOrigin.Begin);\n\n        using (var dstStream = File.OpenWrite(dstFile))\n        {\n            var buffer = new byte[4096]; // buffer size, adjust as needed\n            int bytesRead;\n            while (length > 0 && (bytesRead = srcStream.Read(buffer, 0, Math.Min(buffer.Length, length))) > 0)\n            {\n                dstStream.Write(buffer, 0, bytesRead);\n                length -= bytesRead;\n            }\n        }\n    }\n}