public class FileContentResult : FileResult\n{\n    public byte[] FileContents { get; }\n\n    public FileContentResult(byte[] fileContents, string contentType) : base(contentType)\n    {\n        FileContents = fileContents;\n    }\n\n    // Other members\n}