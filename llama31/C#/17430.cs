using Moq;\nusing NUnit.Framework;\nusing System.Web.Mvc;\n\n[TestFixture]\npublic class RememberUrlFilterTests\n{\n    [Test]\n    public void Should_Save_Current_Url_In_Session()\n    {\n        // Arrange\n        var filter = new RememberUrlFilter();\n        var mockContext = new Mock<ActionExecutedContext>();\n        var mockController = new Mock<ControllerBase>();\n        var mockSession = new Mock<HttpSessionStateBase>();\n\n        mockContext.Setup(c => c.Controller).Returns(mockController.Object);\n        mockContext.Setup(c => c.HttpContext.Session).Returns(mockSession.Object);\n        mockController.Setup(c => c.ControllerContext.HttpContext.Request.Url).Returns(new Uri("http://example.com/current-url"));\n\n        // Act\n        filter.OnActionExecuted(mockContext.Object);\n\n        // Assert\n        mockSession.Verify(s => s.Add("PreviousUrl", "http://example.com/current-url"));\n    }\n}