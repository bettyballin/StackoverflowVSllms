using System;\nusing System.Net;\nusing System.Collections.Specialized;\n\npublic class Program\n{\n    public static void Main()\n    {\n        // Create a new WebClient instance.\n        using (WebClient client = new WebClient())\n        {\n            // Create a new NameValueCollection to hold the login credentials.\n            NameValueCollection loginData = new NameValueCollection();\n            loginData["UserName"] = "your_username";\n            loginData["Password"] = "your_password";\n\n            // Send the login data to the server.\n            byte[] response = client.UploadValues("https://example.com/Login.aspx", "POST", loginData);\n\n            // Retrieve the response cookies.\n            string cookies = client.ResponseHeaders[HttpResponseHeader.SetCookie];\n\n            // Set the cookies in the WebClient instance to maintain the session.\n            client.Headers.Add(HttpRequestHeader.Cookie, cookies);\n\n            // Now download the protected page.\n            string html = client.DownloadString("https://example.com/Internal.aspx");\n\n            // Output the HTML content.\n            Console.WriteLine(html);\n        }\n    }\n}