// In web.config\n<sessionState mode="SQLServer" sqlConnectionString="Data Source=YourDBServer;Initial Catalog=YourDB;Integrated Security=True" />\n\n// In your code\nprotected void Session_Start(object sender, EventArgs e)\n{\n    // Check if the session is new\n    if (Session.IsNewSession)\n    {\n        // Initialize session state\n        Session["Initialized"] = true;\n    }\n}