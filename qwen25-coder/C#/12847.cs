public void SendAcknowledgment(string url, object data)\n{\n    using (HttpClient client = new HttpClient())\n    {\n        var payload = JsonConvert.SerializeObject(data);\n        HttpContent content = new StringContent(payload, Encoding.UTF8, "application/json");\n        HttpResponseMessage response = client.PostAsync(url, content).Result;\n        if (!response.IsSuccessStatusCode)\n            throw new Exception("Failed to send acknowledgment.");\n    }\n}