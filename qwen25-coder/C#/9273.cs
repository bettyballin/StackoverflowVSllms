void Application_Start(object sender, EventArgs e)\n{\n    // Code that runs on application startup\n    HttpRuntime.Cache["MyKey"] = "MyValue"; // Example of setting a cache item\n}