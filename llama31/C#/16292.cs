Response.ClearHeaders();\nResponse.BufferOutput = true;\nResponse.ContentType = "application/octet-stream";\nResponse.AddHeader("content-disposition", "attachment; filename=Images.zip");\nResponse.Cache.SetNoServerCaching();\nResponse.Cache.SetMaxAge(System.TimeSpan.Zero);\n\nZipFile zip = new ZipFile();\nzip.AddFile(Server.MapPath("sample1.png"));\nzip.Save(Response.OutputStream);