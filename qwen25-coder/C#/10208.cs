// Using ScriptManager\nScriptManager.RegisterStartupScript(this, GetType(), "MyScript", "alert('Using ScriptManager');", true);\n\n// Using Page.ClientScript\nPage.ClientScript.RegisterStartupScript(GetType(), "MyScript2", "alert('Using ClientScript');", true);