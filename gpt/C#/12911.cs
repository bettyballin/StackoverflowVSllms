public void ConfigureServices(IServiceCollection services)\n{\n    services.AddScoped<IUserRepository, UserRepository>();\n    services.AddScoped<UserService>();\n}