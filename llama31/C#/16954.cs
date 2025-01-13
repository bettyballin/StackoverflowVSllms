// Use a minimal set of tools and frameworks\nusing Microsoft.AspNetCore.Builder;\nusing Microsoft.AspNetCore.Hosting;\nusing Microsoft.Extensions.DependencyInjection;\n\nnamespace MySimpleProject\n{\n    public class Startup\n    {\n        public void ConfigureServices(IServiceCollection services)\n        {\n            services.AddControllers();\n        }\n\n        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)\n        {\n            app.UseRouting();\n            app.UseEndpoints(endpoints =>\n            {\n                endpoints.MapControllers();\n            });\n        }\n    }\n}