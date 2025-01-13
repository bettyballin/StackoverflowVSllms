public void ConfigureServices(IServiceCollection services)\n   {\n       services.AddInMemoryRateLimiting();\n       services.Configure<IpRateLimitOptions>(options => \n       {\n           options.GeneralRules = new List<RateLimitRule>\n           {\n               new RateLimitRule\n               {\n                   Endpoint = "*",\n                   Period = "1m",\n                   Limit = 100\n               }\n           };\n       });\n   }