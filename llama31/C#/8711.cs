// Example HTTPS request using HttpClient\nusing System.Net.Http;\n\nvar client = new HttpClient();\nclient.DefaultRequestHeaders.Add("Authorization", "Bearer your_token");\n\nvar response = await client.GetAsync("https://yourapi.com/endpoint");