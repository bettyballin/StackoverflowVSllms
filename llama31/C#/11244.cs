foreach (HttpPostedFile file in Request.Files)\n{\n    if (file.ContentLength > 0)\n    {\n        // Process the uploaded file\n        string fileName = file.FileName;\n        string fileType = file.ContentType;\n        byte[] fileBytes = new byte[file.ContentLength];\n        file.InputStream.Read(fileBytes, 0, file.ContentLength);\n        // Save the file or perform other processing as needed\n    }\n}