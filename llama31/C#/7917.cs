using (var fileStream = new FileStream(\n    Path.GetTempFileName(),\n    FileMode.Create,\n    FileAccess.ReadWrite,\n    FileShare.ReadWrite | FileShare.Delete,\n    4096,\n    FileOptions.TemporaryFile))\n{\n    // Write data to the file\n    fileStream.Write(data, 0, data.Length);\n\n    // Launch the application associated with the file\n    Process.Start(fileStream.Name);\n}