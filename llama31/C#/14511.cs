var testConfig = LoadConfigurationFromXml(xml);\nvar section = testConfig.GetSection("mycustomconfigsection") as MyCustomConfigSection;\nAssert.That(section != null);