[TestClass]\npublic class MyLinqTests\n{\n    [TestMethod]\n    public void TestMyLinqQuery()\n    {\n        // Arrange\n        var testData = new List<MyEntity>\n        {\n            new MyEntity { Id = 1, Name = "Test1" },\n            new MyEntity { Id = 2, Name = "Test2" }\n        }.AsQueryable();\n\n        // Act\n        var result = testData.Where(e => e.Id == 1).ToList();\n\n        // Assert\n        Assert.AreEqual(1, result.Count);\n        Assert.AreEqual("Test1", result.First().Name);\n    }\n}