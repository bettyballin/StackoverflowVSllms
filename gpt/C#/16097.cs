using System;\nusing System.Net.Http;\nusing System.Text;\nusing System.Threading.Tasks;\nusing Newtonsoft.Json;\n\npublic class MicrosPosService\n{\n    private readonly HttpClient _httpClient;\n    private readonly string _apiUrl;\n    private readonly string _apiKey;\n\n    public MicrosPosService(string apiUrl, string apiKey)\n    {\n        _httpClient = new HttpClient();\n        _apiUrl = apiUrl;\n        _apiKey = apiKey;\n    }\n\n    public async Task SendOrderAsync(Order order)\n    {\n        var orderJson = JsonConvert.SerializeObject(order);\n        var content = new StringContent(orderJson, Encoding.UTF8, "application/json");\n\n        // Add necessary headers, including authentication\n        _httpClient.DefaultRequestHeaders.Add("Authorization", $"Bearer {_apiKey}");\n\n        var response = await _httpClient.PostAsync($"{_apiUrl}/orders", content);\n\n        if (response.IsSuccessStatusCode)\n        {\n            Console.WriteLine("Order successfully sent to Micros POS.");\n        }\n        else\n        {\n            Console.WriteLine($"Failed to send order: {response.StatusCode}");\n            // Handle error response\n        }\n    }\n}\n\npublic class Order\n{\n    public string OrderId { get; set; }\n    public string CustomerName { get; set; }\n    public string[] Items { get; set; }\n    // Include other necessary fields\n}