protected void Page_Load(object sender, EventArgs e)\n{\n    Response.BufferOutput = false;\n    Response.Write("Step 1<br />");\n    System.Threading.Thread.Sleep(10000);\n    Response.Write("Step 2<br />");\n    System.Threading.Thread.Sleep(10000);\n    Response.Write("Step 3<br />");\n}