using System.Net.Http;\nusing Newtonsoft.Json;\n\npublic class MyApiClient\n{\n    private readonly HttpClient _client;\n\n    public MyApiClient(string baseUrl)\n    {\n        _client = new HttpClient { BaseAddress = new Uri(baseUrl) };\n    }\n\n    public async TaskGetDataAsync()\n    {\n        var response = await _client.GetAsync("my_api/data");\n        response.EnsureSuccessStatusCode();\n        var data = await response.Content.ReadAsStringAsync();\n        return JsonConvert.DeserializeObjectMyData>(data);\n    }\n\n    public async Task PostDataAsync(MyData data)\n    {\n        var content = new StringContent(JsonConvert.SerializeObject(data), Encoding.UTF8, "application/json");\n        var response = await _client.PostAsync("my_api/data", content);\n        response.EnsureSuccessStatusCode();\n    }\n}