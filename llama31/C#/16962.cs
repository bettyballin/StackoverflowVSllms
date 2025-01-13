[Fact]\npublic void Register_ShouldPreventInValidRequest()\n{\n    PrepareController(home, ThorController.KeyPublic, ThorController.KeyHome, HomeController.KeyRegister);\n\n    var dto = new UserRegisterDto { Email = "ff" };\n    var errorSummary = new ErrorSummary();\n    errorSummary.Add("Email", "Email is invalid");\n    home.Errors = errorSummary;\n\n    home.Register(dto);\n\n    Assert.True(Response.WasRedirected);\n    Assert.Contains("/public/home/index", Response.RedirectedTo);\n    Assert.NotNull(home.Errors);\n}