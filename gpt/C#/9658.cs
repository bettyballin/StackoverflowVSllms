protected void Page_Load(object sender, EventArgs e)\n{\n    System.Diagnostics.Debug.WriteLine("Session ID: " + Session.SessionID);\n    foreach (string key in Request.Cookies.AllKeys)\n    {\n        System.Diagnostics.Debug.WriteLine($"Cookie: {key} = {Request.Cookies[key].Value}");\n    }\n}