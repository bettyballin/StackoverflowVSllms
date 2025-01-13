using System;\nusing System.Net.Http;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    private static readonly HttpClient client = new HttpClient();\n\n    static async Task Main(string[] args)\n    {\n        try\n        {\n            string ipAddress = await GetExternalIPAddress();\n            Console.WriteLine($"External IP Address: {ipAddress}");\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"Error getting external IP address: {ex.Message}");\n        }\n    }\n\n    public static async Task<string> GetExternalIPAddress()\n    {\n        // You can use different services like ipify.org, icanhazip.com, etc.\n        HttpResponseMessage response = await client.GetAsync("https://api.ipify.org");\n        response.EnsureSuccessStatusCode();\n        string responseBody = await response.Content.ReadAsStringAsync();\n        return responseBody;\n    }\n}