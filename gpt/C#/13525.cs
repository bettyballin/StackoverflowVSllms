public void ConfigureServices(IServiceCollection services)\n{\n    services.AddHttpClient<MyController>();\n    services.AddControllersWithViews();\n}