// Worker.cs\nusing Microsoft.Extensions.Hosting;\nusing Microsoft.Extensions.Logging;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class Worker : BackgroundService\n{\n    private readonly ILogger<Worker> _logger;\n\n    public Worker(ILogger<Worker> logger)\n    {\n        _logger = logger;\n    }\n\n    protected override async Task ExecuteAsync(CancellationToken stoppingToken)\n    {\n        while (!stoppingToken.IsCancellationRequested)\n        {\n            _logger.LogInformation("Worker running at: {time}", DateTimeOffset.Now);\n            await Task.Delay(1000, stoppingToken);\n        }\n    }\n}\n\n// Program.cs\nusing Microsoft.Extensions.DependencyInjection;\nusing Microsoft.Extensions.Hosting;\n\npublic class Program\n{\n    public static void Main(string[] args)\n    {\n        CreateHostBuilder(args).Build().Run();\n    }\n\n    public static IHostBuilder CreateHostBuilder(string[] args) =>\n        Host.CreateDefaultBuilder(args)\n            .ConfigureServices((hostContext, services) =>\n            {\n                services.AddHostedService<Worker>();\n            });\n}