protected void Button1_Click(object sender, EventArgs e)\n{\n    Guid threadId = ThreadMonitor.StartThread(LongRunningScript);\n    Session["ThreadId"] = threadId;\n    Response.Redirect("PleaseWait.aspx");\n}\n\nprivate void LongRunningScript()\n{\n    // Your long-running script here\n}