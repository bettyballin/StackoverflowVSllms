using System;\nusing System.Net.Http;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class LongRunningWebRequest\n{\n    private readonly HttpClient _httpClient;\n    private readonly TaskCompletionSource<string> _completionSource;\n\n    public LongRunningWebRequest(HttpClient httpClient)\n    {\n        _httpClient = httpClient;\n        _completionSource = new TaskCompletionSource<string>();\n    }\n\n    public async Task<string> SendRequestAsync()\n    {\n        // Start the background work\n        var backgroundTask = Task.Run(() =>\n        {\n            var response = _httpClient.GetAsync("https://example.com/long-running-request").Result;\n            _completionSource.SetResult(response.Content.ReadAsStringAsync().Result);\n        });\n\n        // Wait for the background work to complete\n        return await _completionSource.Task;\n    }\n}