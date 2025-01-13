using Microsoft.AspNetCore.Builder;\nusing Microsoft.AspNetCore.Hosting;\nusing Microsoft.Extensions.DependencyInjection;\nusing Microsoft.Extensions.Hosting;\n\nnamespace MyApi\n{\n    public class Startup\n    {\n        public void ConfigureServices(IServiceCollection services)\n        {\n            services.AddControllers();\n        }\n\n        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)\n        {\n            if (env.IsDevelopment())\n            {\n                app.UseDeveloperExceptionPage();\n            }\n\n            app.UseHttpsRedirection();\n            app.UseRouting();\n            app.UseAuthorization();\n\n            app.UseEndpoints(endpoints =>\n            {\n                endpoints.MapControllers();\n            });\n        }\n    }\n\n    public class MyController : ControllerBase\n    {\n        [HttpGet("api/values")]\n        public IActionResult GetValues()\n        {\n            var values = new[] { "Value1", "Value2" };\n            return Ok(values);\n        }\n    }\n}