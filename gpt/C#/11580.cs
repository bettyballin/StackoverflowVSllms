public byte[] DownloadFileWithRetry(string url, int maxRetries)\n{\n    int retryCount = 0;\n    while (retryCount < maxRetries)\n    {\n        try\n        {\n            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n            using (Stream responseStream = response.GetResponseStream())\n            using (MemoryStream memoryStream = new MemoryStream())\n            {\n                responseStream.CopyTo(memoryStream);\n                return memoryStream.ToArray();\n            }\n        }\n        catch (WebException ex)\n        {\n            if (retryCount >= maxRetries - 1)\n                throw;\n            \n            retryCount++;\n            Thread.Sleep(1000); // Wait before retrying\n        }\n    }\n    throw new Exception("Max retries exceeded.");\n}