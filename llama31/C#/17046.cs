protected override void OnPreInit(EventArgs e)\n{\n    base.OnPreInit(e);\n\n    if (ScriptManager.GetCurrent(Page) == null)\n    {\n        var scriptManager = new ScriptManager();\n        Page.Form.Controls.AddAt(0, scriptManager);\n    }\n}