private void Button1_Click(object sender, EventArgs e)\n{\n    Panel uc = new Panel();\n    // Detach event handlers if any\n    uc.Click -= SomeEventHandler;\n    uc.Dispose();\n}