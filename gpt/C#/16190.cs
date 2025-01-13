// Example code to populate the About box\n\nprivate void PopulateAboutBox()\n{\n    lblProgramName.Text = "My Utility";\n    lblVersion.Text = "Version: 1.0.0";\n    lblAuthor.Text = "Author: Your Name";\n    lblYear.Text = "Year: 2009";\n    \n    lblOSVersion.Text = "OS Version: " + Environment.OSVersion.ToString();\n    lblDotNetVersion.Text = ".NET Framework Version: " + Environment.Version.ToString();\n    lblCurrentDirectory.Text = "Current Directory: " + Environment.CurrentDirectory;\n    lblComputerName.Text = "Computer Name: " + Environment.MachineName;\n    lblUserName.Text = "User Name: " + Environment.UserName;\n    \n    lblLicense.Text = "License: Internal Use Only";\n    lblSupport.Text = "Support: support@yourcompany.com";\n    lblBuildInfo.Text = "Build Date: " + new DateTime(2023, 10, 1).ToString("yyyy-MM-dd");\n}\n\n// Call this method when the About tab is initialized or displayed\nPopulateAboutBox();