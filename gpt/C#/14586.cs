using Moq;\nusing Xunit;\n\npublic class QuestionsControllerTests\n{\n    [Fact]\n    public void SomeAction_ReturnsOkResult()\n    {\n        // Arrange\n        var mockRepository = new Mock<IQuestionsRepository>();\n        // Optionally setup mockRepository behavior\n        var controller = new QuestionsController(mockRepository.Object);\n\n        // Act\n        var result = controller.SomeAction();\n\n        // Assert\n        Assert.IsType<OkResult>(result);\n    }\n}