// Using Fiddler to strip headers\nvar request = Fiddler.WebRequest.Create("http://example.com/search");\nrequest.Method = "GET";\nrequest.Headers.Remove("Accept-Encoding");\n\nvar response = Fiddler.WebResponse.GetResponse(request);