protected void Page_PreRender(object sender, EventArgs e)\n{\n    if (Request.UserAgent.IndexOf("Mozilla/4.0", StringComparison.OrdinalIgnoreCase) != -1)\n    {\n        Response.Filter = null; // Disable compression\n    }\n}