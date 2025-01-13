// C# example of how you might set a registry key on application startup\n   using Microsoft.Win32;\n\n   public void SetUserSettings()\n   {\n       RegistryKey key;\n       try {\n           key = Registry.CurrentUser.CreateSubKey("Software\\YourCompany\\YourApp");\n           if (key != null) {\n               key.SetValue("SettingName", "DefaultValue");\n               key.Close();\n           }\n       } catch (Exception ex) {\n           // handle exception\n       }\n   }