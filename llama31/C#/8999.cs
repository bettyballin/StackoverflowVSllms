var settings = System.Configuration.ConfigurationManager.GetSection("PhotoImportRobot.My.MySettings") as System.Configuration.ClientSettingsSection;\nvar adiImageVariantsRoot = settings.Settings["ADIImageVariantsRoot"].Value;