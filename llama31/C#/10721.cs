using System.Properties;\n\npublic class MySettings : Settings\n{\n    public string MySetting { get; set; }\n}\n\npublic class MyClass\n{\n    public void SaveSettings()\n    {\n        MySettings settings = new MySettings();\n        settings.MySetting = "SomeValue";\n        settings.Save();\n    }\n\n    public void LoadSettings()\n    {\n        MySettings settings = new MySettings();\n        settings.Reload();\n        string mySetting = settings.MySetting;\n    }\n}