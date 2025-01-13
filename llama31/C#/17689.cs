public void UpdateToolstrip(string text)\n{\n    if (this.toolStripLabel1.InvokeRequired == false)\n    {\n        this.toolStripLabel1.Text = text;\n    }\n    else\n    {\n        this.toolStripLabel1.BeginInvoke(new UpdateToolstripDelegate(UpdateToolstrip), new object[] { text });\n    }\n}