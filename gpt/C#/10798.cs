public class FilePathResult : FileResult\n{\n    public string FileName { get; }\n\n    public FilePathResult(string fileName, string contentType) : base(contentType)\n    {\n        FileName = fileName;\n    }\n\n    // Other members\n}