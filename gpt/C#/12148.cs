string userInput = Request.QueryString["input"];\n    Response.Write(Server.HtmlEncode(userInput));