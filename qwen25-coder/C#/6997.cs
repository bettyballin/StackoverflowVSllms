var options = new DbContextOptionsBuilder<ApplicationDbContext>()\n        .UseInMemoryDatabase(databaseName: "TestDb")\n        .Options;\n\n    using (var context = new ApplicationDbContext(options))\n    {\n        // Test code here...\n    }