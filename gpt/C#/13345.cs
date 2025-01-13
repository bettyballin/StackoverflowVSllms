var options = new DbContextOptionsBuilder<MyContext>()\n                  .UseInMemoryDatabase(databaseName: "TestDatabase")\n                  .Options;\n\n    using (var context = new MyContext(options))\n    {\n        context.Items.Add(new Item { Id = 1, Name = "Test Item" });\n        context.SaveChanges();\n\n        var service = new ItemService(context);\n        var result = service.GetItem(1);\n\n        Assert.AreEqual("Test Item", result.Name);\n    }