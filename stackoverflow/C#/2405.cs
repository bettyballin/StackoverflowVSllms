using (MyDataContext ctx = new MyDataContext())\n{\n    StringWriter sw = new StringWriter();\n    ctx.Log = sw;\n\n    // execute some LINQ to SQL operations...\n\n    string sql = sw.ToString();\n    // put a breakpoint here, log it to a file, etc...\n}   