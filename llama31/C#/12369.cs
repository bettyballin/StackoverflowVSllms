// Part1ControllerTest.cs\n[TestMethod]\npublic void Index_ReturnsPartialView_WithModel()\n{\n    // Arrange\n    var dataServiceMock = new Mock<IPart1DataService>();\n    var controller = new Part1Controller(dataServiceMock.Object);\n\n    // Act\n    var result = controller.Index() as PartialViewResult;\n\n    // Assert\n    Assert.IsNotNull(result);\n    Assert.IsInstanceOfType(result.Model, typeof(Part1Model));\n}