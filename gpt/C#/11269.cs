using Hangfire;\nusing Owin;\n\npublic class Startup\n{\n    public void Configuration(IAppBuilder app)\n    {\n        // Basic configuration with in-memory storage (for demo purposes)\n        GlobalConfiguration.Configuration.UseMemoryStorage();\n        \n        // Start Hangfire server\n        app.UseHangfireServer();\n        app.UseHangfireDashboard();\n    }\n}