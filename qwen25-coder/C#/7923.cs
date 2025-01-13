FileStream MyFileStream = new FileStream(filePath, FileMode.Open);\nlong FileSize = MyFileStream.Length;\nbyte[] Buffer = new byte[FileSize]; // Corrected line here\nMyFileStream.Read(Buffer, 0, (int)FileSize); // No change needed here\nMyFileStream.Close();\nResponse.ContentType = "application/pdf";\nResponse.AddHeader("content-disposition", $"attachment; filename={Path.GetFileName(filePath)}"); // Fixed file name handling\nResponse.BinaryWrite(Buffer);