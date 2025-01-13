public class Startup\n   {\n       public void ConfigureServices(IServiceCollection services)\n       {\n           services.AddDbContext<ApplicationDbContext>(options =>\n               options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection")));\n           \n           // Other service configurations\n       }\n\n       // Other configurations\n   }