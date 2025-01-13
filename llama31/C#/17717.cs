using System.Configuration;\n\npublic class WebConfigEditor\n{\n    public static void EditWebConfig(string key, string value)\n    {\n        // Open the Web.config file\n        Configuration config = WebConfigurationManager.OpenWebConfiguration("~");\n\n        // Get the appSettings section\n        KeyValueConfigurationCollection appSettings = config.AppSettings.Settings;\n\n        // Add or update the key-value pair\n        if (appSettings[key] != null)\n        {\n            appSettings[key].Value = value;\n        }\n        else\n        {\n            appSettings.Add(key, value);\n        }\n\n        // Save the changes\n        config.Save(ConfigurationSaveMode.Modified);\n    }\n}