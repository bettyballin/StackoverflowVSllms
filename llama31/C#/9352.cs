using System.Configuration;\n\n// Get the configuration file\nConfiguration config = WebConfigurationManager.OpenWebConfiguration("~");\n\n// Get the appSettings section\nKeyValueConfigurationCollection appSettings = (KeyValueConfigurationCollection)config.AppSettings.Settings;\n\n// Modify the "homepagedesc" key\nappSettings["homepagedesc"].Value = "New value";\n\n// Save the changes\nconfig.Save(ConfigurationSaveMode.Modified);