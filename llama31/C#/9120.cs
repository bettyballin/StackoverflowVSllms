var configurationClient = new ConfigurationClient("https://config.example.com");\nvar cachingPolicies = await configurationClient.GetConfigurationAsync("caching-policies.xml");