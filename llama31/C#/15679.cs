foreach (string item in TempFilesList)\n{\n    string path = Server.MapPath("~/temp/" + item);\n    File.Delete(path);\n}