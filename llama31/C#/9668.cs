_container.Register(\n    AllTypes.Pick(t => t.IsClass && t.Name.StartsWith("My"))\n        .FromAssembly(Assembly.GetExecutingAssembly())\n        .WithService.FirstInterface());