using System.Net.Http;\n\nHttpClient client = new HttpClient();\nHttpResponseMessage response = await client.GetAsync("https://api.example.com/data");\n\nstring responseBody = await response.Content.ReadAsStringAsync();