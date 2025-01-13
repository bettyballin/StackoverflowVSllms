protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Prevent Caching\n        Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));\n        Response.Cache.SetCacheability(HttpCacheability.NoCache);\n        Response.Cache.SetNoStore();\n    }\n}