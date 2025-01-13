protected void Application_BeginRequest(object sender, EventArgs e)\n{\n    HttpResponse response = HttpContext.Current.Response;\n    HttpRequest request = HttpContext.Current.Request;\n\n    string acceptEncoding = request.Headers["Accept-Encoding"];\n    if (acceptEncoding != null && acceptEncoding.Contains("gzip"))\n    {\n        response.AppendHeader("Content-encoding", "gzip");\n        response.Filter = new System.IO.Compression.GZipStream(response.Filter, \n            System.IO.Compression.CompressionMode.Compress);\n    }\n}