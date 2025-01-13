using System.Net;\nusing System.IO;\n\npublic class RestClient\n{\n    public string MakeGetRequest(string url)\n    {\n        HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n        request.Method = "GET";\n        HttpWebResponse response = (HttpWebResponse)request.GetResponse();\n\n        string responseString = "";\n        using (Stream responseStream = response.GetResponseStream())\n        {\n            using (StreamReader reader = new StreamReader(responseStream))\n            {\n                responseString = reader.ReadToEnd();\n            }\n        }\n        return responseString;\n    }\n}