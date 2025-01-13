using System;\nusing System.Net.Http;\nusing System.Text;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    static async Task Main(string[] args)\n    {\n        string url = "https://api.cliqset.com/200905/user/cosmorocket/status";\n        string consumerKey = "11**********3c2ccd26c4ca946e3d8e";\n        string authorization = "Basic Y**********rZXQ6ZnVsY3J1bTA=";\n        string updatedStatus = "<StatusEntry><Status>Updated status message</Status></StatusEntry>";\n\n        using (HttpClient client = new HttpClient())\n        {\n            client.DefaultRequestHeaders.Add("CliqsetConsumerKey", consumerKey);\n            client.DefaultRequestHeaders.Add("Authorization", authorization);\n            client.DefaultRequestHeaders.Add("Content-Type", "application/xml");\n\n            HttpContent content = new StringContent(updatedStatus, Encoding.UTF8, "application/xml");\n\n            HttpResponseMessage response = await client.PutAsync(url, content);\n\n            string responseContent = await response.Content.ReadAsStringAsync();\n            Console.WriteLine((int)response.StatusCode);\n            Console.WriteLine(response.ReasonPhrase);\n            Console.WriteLine(responseContent);\n        }\n    }\n}