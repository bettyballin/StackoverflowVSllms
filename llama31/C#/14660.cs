using System.Collections.Generic;\nusing System.Linq;\nusing Microsoft.VisualStudio.TestTools.UnitTesting;\n\nnamespace MyTests\n{\n    [TestClass]\n    public class MyTests\n    {\n        [TestMethod]\n        public void TestMyLinqQuery()\n        {\n            // Create a collection of test objects\n            var testObjects = new List<MyObject>\n            {\n                new MyObject { Id = 1, Name = "John" },\n                new MyObject { Id = 2, Name = "Jane" },\n                new MyObject { Id = 3, Name = "Bob" }\n            };\n\n            // Test the LINQ query\n            var result = from o in testObjects\n                         where o.Name.StartsWith("J")\n                         select o;\n\n            // Assert the results\n            Assert.AreEqual(2, result.Count());\n            Assert.AreEqual("John", result.First().Name);\n        }\n    }\n\n    public class MyObject\n    {\n        public int Id { get; set; }\n        public string Name { get; set; }\n    }\n}