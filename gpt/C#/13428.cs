public class Startup\n{\n    public Startup(IConfiguration configuration)\n    {\n        Configuration = configuration;\n    }\n\n    public IConfiguration Configuration { get; }\n\n    public void ConfigureServices(IServiceCollection services)\n    {\n        services.AddControllersWithViews();\n\n        // Access AWS keys from environment variables\n        var awsAccessKey = Environment.GetEnvironmentVariable("AWS_ACCESS_KEY");\n        var awsSecretKey = Environment.GetEnvironmentVariable("AWS_SECRET_KEY");\n        \n        services.AddAWSService<IAmazonS3>(new AmazonS3Config\n        {\n            RegionEndpoint = RegionEndpoint.USEast1,\n            Credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey)\n        });\n    }\n\n    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)\n    {\n        if (env.IsDevelopment())\n        {\n            app.UseDeveloperExceptionPage();\n        }\n        else\n        {\n            app.UseExceptionHandler("/Home/Error");\n            app.UseHsts();\n        }\n\n        app.UseHttpsRedirection();\n        app.UseStaticFiles();\n        app.UseRouting();\n        app.UseAuthorization();\n        app.UseEndpoints(endpoints =>\n        {\n            endpoints.MapControllerRoute(\n                name: "default",\n                pattern: "{controller=Home}/{action=Index}/{id?}");\n        });\n    }\n}