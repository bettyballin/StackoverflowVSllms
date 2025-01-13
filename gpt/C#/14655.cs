public void ConfigureServices(IServiceCollection services)\n   {\n       services.AddDbContext<AppDbContext>(options =>\n           options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection")));\n\n       services.AddControllers();\n   }