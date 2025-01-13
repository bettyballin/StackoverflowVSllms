using System;\nusing System.Net;\nusing System.Net.Http;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class HttpProxy : HttpMessageHandler\n{\n    protected override async Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)\n    {\n        Console.WriteLine($"Request: {request.Method} {request.RequestUri}");\n\n        // Forward the request to the original destination\n        var response = await base.SendAsync(request, cancellationToken);\n\n        Console.WriteLine($"Response: {response.StatusCode}");\n\n        return response;\n    }\n}\n\nclass Program\n{\n    static async Task Main(string[] args)\n    {\n        var proxy = new HttpProxy();\n        var handler = new HttpClientHandler { Proxy = new WebProxy(proxy) };\n        var client = new HttpClient(handler);\n\n        // Use the client to make requests\n        var response = await client.GetAsync("https://example.com");\n\n        Console.WriteLine($"Response: {response.StatusCode}");\n    }\n}