[Test]\npublic void TestNameProperty()\n{\n    var viewModel = new MyViewModel();\n    viewModel.Name = "John";\n    Assert.AreEqual("John", viewModel.Name);\n}\n\n[Test]\npublic void TestSaveCommand()\n{\n    var viewModel = new MyViewModel();\n    viewModel.SaveCommand.Execute(null);\n    // Verify that the save logic was executed\n}