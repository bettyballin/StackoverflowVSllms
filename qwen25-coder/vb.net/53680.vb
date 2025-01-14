Imports System.Configuration\n\nModule Module1\n\n    Sub Main()\n        Dim configFilePath As String = "C:\path\to\web.config"\n        Dim configFileMap As New ExeConfigurationFileMap With {.ExeConfigFilename = configFilePath}\n        Dim config As Configuration = ConfigurationManager.OpenMappedExeConfiguration(configFileMap, ConfigurationUserLevel.None)\n\n        ' Example: Change a key in <appSettings>\n        If config.AppSettings.Settings("SettingKey") IsNot Nothing Then\n            config.AppSettings.Settings("SettingKey").Value = "New Value"\n        Else\n            config.AppSettings.Settings.Add("SettingKey", "New Value")\n        End If\n\n        ' Example: Add a connection string\n        Dim connectionStringsSection As ConnectionStringsSection = config.ConnectionStrings\n        If connectionStringsSection.ConnectionStrings("MyConnectionString") Is Nothing Then\n            connectionStringsSection.ConnectionStrings.Add(New ConnectionStringSettings("MyConnectionString", "Data Source=.;Initial Catalog=DBName;Integrated Security=True"))\n        End If\n\n        ' Save the configuration file.\n        config.Save(ConfigurationSaveMode.Modified)\n    End Sub\n\nEnd Module