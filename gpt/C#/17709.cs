public void ConfigureServices(IServiceCollection services)\n{\n    services.AddQuartz(q =>\n    {\n        q.UseMicrosoftDependencyInjectionJobFactory();\n        \n        var jobKey = new JobKey("SendEmailsJob");\n        q.AddJob<SendEmailsJob>(opts => opts.WithIdentity(jobKey));\n        q.AddTrigger(opts => opts\n            .ForJob(jobKey)\n            .WithIdentity("SendEmailsTrigger")\n            .WithCronSchedule("0 0 12 * * ?")); // Every day at noon\n    });\n\n    services.AddQuartzHostedService(q => q.WaitForJobsToComplete = true);\n}\n\npublic void Configure(IApplicationBuilder app, IHostingEnvironment env)\n{\n    // Other configurations...\n}