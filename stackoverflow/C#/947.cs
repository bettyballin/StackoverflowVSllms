foreach (string item in TempFilesList)\n{\n    path = System.Web.HttpContext.Current.Application["baseWebDomainUrl"] + "/temp/" + item;\n    path = Server.MapPath(path);\n    fileDel = new FileInfo(path);\n    fileDel.Delete();\n}