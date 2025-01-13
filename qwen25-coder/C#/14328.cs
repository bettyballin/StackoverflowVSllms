using System;\nusing System.IO;\nusing System.Net;\n\npublic class WebRequestHelper\n{\n    public static void MakeRequest(string url, string postData)\n    {\n        HttpWebRequest request = null;\n        try\n        {\n            // Setting up the web request\n            request = (HttpWebRequest)WebRequest.Create(url);\n            request.Method = "POST";\n            request.ContentType = "application/x-www-form-urlencoded";\n            request.Timeout = 30000; // Set timeout to 30 seconds\n            ServicePointManager.DefaultConnectionLimit = 10; // Increase connection limit if needed\n            \n            // Disable keep-alive connections for testing\n            request.KeepAlive = false;\n\n            byte[] byteArray = System.Text.Encoding.UTF8.GetBytes(postData);\n            request.ContentLength = byteArray.Length;\n\n            using (Stream dataStream = request.GetRequestStream())\n            {\n                dataStream.Write(byteArray, 0, byteArray.Length);\n            }\n\n            // Get the response.\n            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n            using (Stream responseStream = response.GetResponseStream())\n            using (StreamReader reader = new StreamReader(responseStream))\n            {\n                string responseFromServer = reader.ReadToEnd();\n                Console.WriteLine("Response Received : {0}", responseFromServer);\n            }\n        }\n        catch (WebException webEx)\n        {\n            if (webEx.Response != null)\n            {\n                using (var errorResponse = (HttpWebResponse)webEx.Response)\n                {\n                    string message;\n                    using (var reader = new StreamReader(errorResponse.GetResponseStream()))\n                    {\n                        message = reader.ReadToEnd();\n                    }\n                    Console.WriteLine("WebException: {0}", message);\n                }\n            }\n        }\n    }\n}