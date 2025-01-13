var request = new Mock<HttpRequestBase>();\nrequest.SetupGet(r => r.HttpMethod).Returns("GET");\nrequest.SetupGet(r => r.Url).Returns(new Uri("http://somesite/action"));\n\nvar httpContext = new Mock<HttpContextBase>();\nhttpContext.SetupGet(c => c.Request).Returns(request.Object);\n\nvar actionExecutedContext = new Mock<ActionExecutedContext>();\nactionExecutedContext.SetupGet(c => c.HttpContext).Returns(httpContext.Object);