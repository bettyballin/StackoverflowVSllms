// NUnit\n    using NUnit.Framework;\n\n    [TestFixture]\n    public class MyTests\n    {\n        [SetUp]\n        public void Setup() { }\n\n        [Test]\n        public void TestMethod() { }\n\n        [TearDown]\n        public void Teardown() { }\n    }\n\n    // MSTest\n    using Microsoft.VisualStudio.TestTools.UnitTesting;\n\n    [TestClass]\n    public class MyTests\n    {\n        [TestInitialize]\n        public void Setup() { }\n\n        [TestMethod]\n        public void TestMethod() { }\n\n        [TestCleanup]\n        public void Teardown() { }\n    }