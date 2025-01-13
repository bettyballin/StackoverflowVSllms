public void ProcessRequest(HttpContext context)\n{\n    context.Response.ContentType = "text/csv; charset=UTF-8";\n    context.Response.Charset = "UTF-8";\n    context.Response.ContentEncoding = System.Text.Encoding.UTF8;\n    context.Response.AddHeader("Content-disposition", "attachment;filename=lista_obecnosci.csv");\n\n    // Write UTF-8 Byte Order Mark (BOM)\n    byte[] bom = new byte[] { 0xEF, 0xBB, 0xBF };\n    context.Response.OutputStream.Write(bom, 0, bom.Length);\n\n    context.Response.Write("ąęćżźńółĄŚŻŹĆŃŁÓĘ");\n}