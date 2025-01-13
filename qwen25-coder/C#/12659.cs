using System;\nusing System.Configuration;\nusing System.Xml;\n\npublic class MyAppConfiguration\n{\n    private static Configuration GetCustomConfig()\n    {\n        string configFilePath = AppDomain.CurrentDomain.BaseDirectory + "YourSubdirectory\\MyAppConfig.xml";\n        ExeConfigurationFileMap configFileMap = new ExeConfigurationFileMap { ExeConfigFilename = configFilePath };\n        return ConfigurationManager.OpenMappedExeConfiguration(configFileMap, ConfigurationUserLevel.None);\n    }\n\n    public static string GetSetting(string key)\n    {\n        Configuration config = GetCustomConfig();\n        KeyValueConfigurationCollection settings = config.AppSettings.Settings;\n        if (settings[key] != null)\n            return settings[key].Value;\n        else\n            return String.Empty; // or throw an exception based on your requirement\n    }\n}\n\n// Usage\nstring clientName = MyAppConfiguration.GetSetting("ClientName");\nstring logoLocation = MyAppConfiguration.GetSetting("LogoLocation");