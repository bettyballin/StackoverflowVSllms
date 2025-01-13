using Moq;\nusing NUnit.Framework;\n\npublic interface IWordApplication\n{\n    void DoSomething();\n}\n\npublic class WordAddIn\n{\n    private readonly IWordApplication _wordApp;\n\n    public WordAddIn(IWordApplication wordApp)\n    {\n        _wordApp = wordApp;\n    }\n\n    public void Execute()\n    {\n        // Business logic that interacts with Word\n        _wordApp.DoSomething();\n    }\n}\n\n[TestFixture]\npublic class WordAddInTests\n{\n    [Test]\n    public void Execute_ShouldCallDoSomething()\n    {\n        // Arrange\n        var mockWordApp = new Mock<IWordApplication>();\n        var addIn = new WordAddIn(mockWordApp.Object);\n\n        // Act\n        addIn.Execute();\n\n        // Assert\n        mockWordApp.Verify(app => app.DoSomething(), Times.Once);\n    }\n}