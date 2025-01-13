protected override void OnInit(EventArgs e)\n{\n    base.OnInit(e); // Always call the base method first\n    Page.SaveStateComplete += RegisterSaveStuff;\n}\n\nprivate void RegisterSaveStuff(object sender, EventArgs e)\n{\n    ClientScript.RegisterOnSubmitStatement(typeof(Page), "uniqueKey", "yourJavaScriptCode();");\n}