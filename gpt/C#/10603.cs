using Moq;\nusing Xunit;\n\npublic class YourClassTests\n{\n    [Fact]\n    public void Start_ShouldStartProcess_WhenNotRunning()\n    {\n        // Arrange\n        var processWrapperMock = new Mock<IProcessWrapper>();\n        var cmdLine = "dummyCmd";\n        var args = "dummyArgs";\n        var yourClass = new YourClass(processWrapperMock.Object, cmdLine, args);\n\n        // Act\n        yourClass.Start();\n\n        // Assert\n        processWrapperMock.Verify(p => p.Start(It.Is<ProcessStartInfo>(info =>\n            info.FileName == cmdLine &&\n            info.Arguments == args &&\n            info.CreateNoWindow &&\n            info.UseShellExecute\n        )), Times.Once);\n    }\n\n    [Fact]\n    public void Start_ShouldThrowException_WhenAlreadyRunning()\n    {\n        // Arrange\n        var processWrapperMock = new Mock<IProcessWrapper>();\n        var cmdLine = "dummyCmd";\n        var args = "dummyArgs";\n        var yourClass = new YourClass(processWrapperMock.Object, cmdLine, args);\n\n        // Act\n        yourClass.Start();\n\n        // Assert\n        Assert.Throws<InvalidOperationException>(() => yourClass.Start());\n    }\n}