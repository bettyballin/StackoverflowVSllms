protected void Page_PreInit(object sender, EventArgs e)\n{\n    if (Context.Session != null)\n    {\n        if (Session["foo"] != null)\n        {\n            Session.Remove("foo");\n        }\n    }\n}