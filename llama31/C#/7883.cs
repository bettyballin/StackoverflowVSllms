var client = new WebClient();\nvar sourceCode = await client.GetSourceCodeAsync("http://www.example.com");\nConsole.WriteLine(sourceCode);