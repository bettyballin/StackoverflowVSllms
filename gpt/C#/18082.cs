public void ConfigureServices(IServiceCollection services)\n    {\n        services.AddControllers();\n        services.AddSingleton<ProductService>();\n    }