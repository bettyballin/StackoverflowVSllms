Dim config As Configuration = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None)\nDim settings As ClientSettingsSection = CType(config.GetSection("applicationSettings/MyClassLibrary.My.MySettings"), ClientSettingsSection)\nDim connectionStringSetting As SettingElement = settings.Settings.Get("MyConnectionString")\n\nconnectionStringSetting.Value.ValueXml.InnerText = "New Connection String Value"\n\nconfig.Save(ConfigurationSaveMode.Modified)