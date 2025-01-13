public class ResponseCompressionStartup\n{\n    public void ConfigureServices(IServiceCollection services)\n    {\n        services.AddResponseCompression(options =>\n        {\n            options.EnableForHttps = true;\n            options.MimeTypes = ResponseCompressionDefaults.MimeTypes.Concat(\n                new[] { "text/html" });\n        });\n\n        // Register Gzip Compressor Provider\n        services.Configure<GzipCompressionProviderOptions>(options =>\n            options.Level = System.IO.Compression.CompressionLevel.Fastest);\n    }\n\n    public void Configure(IApplicationBuilder app)\n    {\n        // Enable response compression middleware\n        app.UseResponseCompression();\n\n        // Other middleware registrations\n        app.UseRouting();\n        app.UseEndpoints(endpoints => { endpoints.MapControllers(); });\n    }\n}