\n    void Application_Start(object sender, EventArgs e) \n    {\n        // Code that runs on application startup\n\n        // check that the minimal security settings are created\n        Security.SetupSecurity();\n    }