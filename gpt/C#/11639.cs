protected void Page_Load(object sender, EventArgs e)\n{\n    if (Session["Example"] == null)\n    {\n        Session["Example"] = "This is a new session.";\n        Response.Write("New session started: " + Session.SessionID);\n    }\n    else\n    {\n        Response.Write("Existing session: " + Session.SessionID);\n    }\n}