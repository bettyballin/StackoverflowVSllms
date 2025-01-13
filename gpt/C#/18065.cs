using Moq;\nusing Xunit;\n\npublic class MyServiceTests\n{\n    [Fact]\n    public void Test_Method()\n    {\n        // Arrange\n        var mockRepository = new Mock<IMyRepository>();\n        mockRepository.Setup(repo => repo.GetData()).Returns("mock data");\n        var service = new MyService(mockRepository.Object);\n\n        // Act\n        var result = service.GetData();\n\n        // Assert\n        Assert.Equal("mock data", result);\n    }\n}