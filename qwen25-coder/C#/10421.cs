protected void Page_Load(object sender, EventArgs e)\n{\n    // Disable client-side caching\n    Response.Cache.SetCacheability(HttpCacheability.NoCache);\n    Response.Cache.SetExpires(DateTime.UtcNow.AddMinutes(-1));\n    Response.Cache.SetNoStore();\n    \n    if (!Page.IsPostBack)\n    {\n        DataBindDropDowns();\n\n        if (HasQueryString())\n        {\n            SetOptionsFromQueryString();\n            SavePageToSession();\n            // Do a server-side redirect\n            Response.Redirect("Default.aspx");\n        }\n        else\n        {\n            RestoreFromSession();\n            DisplayOptions();\n        }\n    }\n}