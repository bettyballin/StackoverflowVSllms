[TestClass]\npublic class SomeServiceTests\n{\n    [TestMethod]\n    public void SomeMethod_Should_BehaveCorrectly()\n    {\n        // Arrange\n        var fakeDateTimeProvider = new FakeDateTimeProvider\n        {\n            Now = new DateTime(2023, 1, 1)\n        };\n        var service = new SomeService(fakeDateTimeProvider);\n\n        // Act\n        service.SomeMethod();\n\n        // Assert\n        // Your assertions here\n    }\n}