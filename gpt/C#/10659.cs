using System;\nusing System.Net;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string url = "http://destination_page_url";\n        var request = (HttpWebRequest)WebRequest.Create(url);\n        request.Referer = "http://fake-referer.com";\n        \n        using (var response = (HttpWebResponse)request.GetResponse())\n        {\n            using (var stream = response.GetResponseStream())\n            {\n                // Process the response\n            }\n        }\n    }\n}