public static bool IsFile(string path)\n{\n    var attr = File.GetAttributes(path);\n    return !attr.HasFlag(FileAttributes.Directory);\n}