using System;\nusing System.Reflection;\nusing NUnit.Framework;\n\nnamespace YourNamespace\n{\n    public class YourClass\n    {\n        private int AddNumbers(int a, int b)\n        {\n            return a + b;\n        }\n    }\n\n    [TestFixture]\n    public class YourClassTests\n    {\n        [Test]\n        public void TestAddNumbers()\n        {\n            // Arrange\n            var yourClassInstance = new YourClass();\n            MethodInfo methodInfo = typeof(YourClass).GetMethod("AddNumbers", BindingFlags.NonPublic | BindingFlags.Instance);\n            Assert.IsNotNull(methodInfo, "Method not found");\n\n            // Act\n            var result = methodInfo.Invoke(yourClassInstance, new object[] { 1, 2 });\n\n            // Assert\n            Assert.AreEqual(3, result);\n        }\n    }\n}