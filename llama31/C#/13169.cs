public void Session_Start(object sender, EventArgs e)\n{\n    // Session is available\n    Session.Remove("foo");\n}