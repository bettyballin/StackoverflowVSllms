using System;\nusing System.Net.Http;\nusing System.Net.Http.Headers;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    static async Task Main(string[] args)\n    {\n        string url = "https://www.azet.sk"; // Replace with the actual login URL\n        string loginEndpoint = "/login"; // Replace with the actual login endpoint\n\n        var client = new HttpClient();\n\n        var loginData = new FormUrlEncodedContent(new[]\n        {\n            new KeyValuePair<string, string>("username", "your_username"),\n            new KeyValuePair<string, string>("password", "your_password")\n        });\n\n        HttpResponseMessage response = await client.PostAsync(url + loginEndpoint, loginData);\n\n        if (response.IsSuccessStatusCode)\n        {\n            Console.WriteLine("Logged in successfully");\n\n            // Retrieve some data after login\n            // For example, accessing a protected resource\n            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/html"));\n            var result = await client.GetStringAsync(url + "/protectedResource"); // Replace with the actual protected resource URL\n            Console.WriteLine(result);\n        }\n        else\n        {\n            Console.WriteLine("Login failed");\n        }\n    }\n}