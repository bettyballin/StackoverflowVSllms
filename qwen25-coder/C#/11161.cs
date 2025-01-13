// Example of setting secure cookie options in ASP.NET Core\npublic void ConfigureServices(IServiceCollection services)\n{\n    services.ConfigureApplicationCookie(options =>\n    {\n        options.Cookie.SecurePolicy = CookieSecurePolicy.Always; // Enforce HTTPS\n        options.Cookie.IsEssential = true; // Required for authentication\n        options.ExpireTimeSpan = TimeSpan.FromMinutes(20); // Short TTL\n        options.SlidingExpiration = false; // Disable sliding expiration\n    });\n}