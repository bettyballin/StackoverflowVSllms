using System;\nusing System.Net.Http;\nusing System.Text;\nusing System.Threading.Tasks;\n\npublic class RestClient\n{\n    private static readonly HttpClient httpClient = new HttpClient();\n\n    public async Task SendDataAsync(string serviceUrl, string xmlData)\n    {\n        var content = new StringContent(xmlData, Encoding.UTF8, "application/xml");\n\n        HttpResponseMessage response = await httpClient.PostAsync(serviceUrl, content);\n\n        if (response.IsSuccessStatusCode)\n        {\n            Console.WriteLine("Data posted successfully.");\n        }\n        else\n        {\n            Console.WriteLine($"Failed to post data. Status code: {response.StatusCode}");\n        }\n    }\n}