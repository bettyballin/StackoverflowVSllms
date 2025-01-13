void CopyStream(Stream destination, Stream source) {\n   int count;\n   byte[] buffer = new byte[BUFFER_SIZE];\n   while( (count = source.Read(buffer, 0, buffer.Length)) > 0)\n       destination.Write(buffer, 0, count);\n}\n\n\nCopyStream(outputFileStream, fileStream1);\nCopyStream(outputFileStream, fileStream2);\nCopyStream(outputFileStream, fileStream3);