using System;\nusing System.IO;\nusing System.Net;\nusing System.Threading;\n\nclass Program\n{\n    static void Main()\n    {\n        for (int i = 0; i < 3; i++)\n        {\n            string strPageNo = i.ToString();\n            string strURL = "http://www.website.com/results.aspx?page=" + strPageNo;\n\n            HttpWebRequest wrGETURL = (HttpWebRequest)WebRequest.Create(strURL);\n            wrGETURL.Method = "GET";\n            wrGETURL.Accept = "text/html";\n            wrGETURL.UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";\n            wrGETURL.Headers.Add("Cache-Control", "no-cache");\n            wrGETURL.CookieContainer = new CookieContainer();\n\n            using (HttpWebResponse response = (HttpWebResponse)wrGETURL.GetResponse())\n            {\n                using (Stream objStream = response.GetResponseStream())\n                {\n                    using (StreamReader objReader = new StreamReader(objStream))\n                    {\n                        string responseFromServer = objReader.ReadToEnd();\n\n                        // Save the response to a file or process it as needed\n                        // For example, save to a file named "page_i.html"\n                        File.WriteAllText($"page_{i}.html", responseFromServer);\n                    }\n                }\n            }\n\n            // Ensure the server doesn't get hammered\n            Thread.Sleep(1000);\n        }\n    }\n}