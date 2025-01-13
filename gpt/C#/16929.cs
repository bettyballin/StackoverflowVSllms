using System;\nusing System.IO;\nusing System.Net;\n\npublic class WebPageFetcher\n{\n    public static string GetHtml(string url)\n    {\n        string html = string.Empty;\n\n        try\n        {\n            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n            request.Method = "GET";\n\n            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n            using (StreamReader reader = new StreamReader(response.GetResponseStream()))\n            {\n                html = reader.ReadToEnd();\n            }\n        }\n        catch (Exception ex)\n        {\n            // Handle exceptions\n            Console.WriteLine("Error: " + ex.Message);\n        }\n\n        return html;\n    }\n}