public class Startup\n{\n    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)\n    {\n        if (env.IsDevelopment())\n        {\n            app.UseDeveloperExceptionPage();\n        }\n        else\n        {\n            app.UseExceptionHandler("/Home/Error");\n            app.UseHsts();\n        }\n\n        app.UseHttpsRedirection();\n        app.UseStaticFiles();\n\n        // Configure virtual directory for static files\n        app.UseStaticFiles(new StaticFileOptions\n        {\n            FileProvider = new PhysicalFileProvider(\n                Path.Combine(env.ContentRootPath, "wwwroot", "virtual-directory")),\n            RequestPath = "/virtual-directory"\n        });\n\n        app.UseRouting();\n\n        app.UseAuthentication();\n        app.UseAuthorization();\n\n        app.UseEndpoints(endpoints =>\n        {\n            endpoints.MapControllerRoute(\n                name: "default",\n                pattern: "{controller=Home}/{action=Index}/{id?}");\n        });\n    }\n}