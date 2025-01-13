FileUpload fileUpload = new FileUpload();\nif (fileUpload.HasFile)\n{\n    string fileName = fileUpload.FileName;\n    string fileExtension = Path.GetExtension(fileName);\n    if (IsAllowedFileExtension(fileExtension))\n    {\n        fileUpload.SaveAs(Server.MapPath("~/uploads/" + fileName));\n    }\n}\n\n// Helper method to check if the file extension is allowed\nprivate bool IsAllowedFileExtension(string fileExtension)\n{\n    // Define a list of allowed file extensions\n    string[] allowedExtensions = { ".doc", ".docx", ".pdf" };\n    return allowedExtensions.Contains(fileExtension);\n}