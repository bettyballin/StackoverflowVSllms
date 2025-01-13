using System;\nusing System.IO;\nusing System.Net;\nusing System.Security.Cryptography;\nusing System.Text;\n\nnamespace ZeepMobileExample\n{\n    class Program\n    {\n        public static string API_KEY = "YOUR_API_KEY";\n        public static string SECRET_ACCESS_KEY = "YOUR_SECRET_KEY";\n        public static string API_URL = "https://api.zeepmobile.com/messaging/2008-07-14/blast_message";\n\n        static void Main(string[] args)\n        {\n            SendMessage("Hello, this is a test message!", "recipient_number");\n        }\n\n        static void SendMessage(string message, string recipient)\n        {\n            try\n            {\n                string http_date = DateTime.UtcNow.ToString("r");\n                string data = $"message={Uri.EscapeDataString(message)}&recipient={Uri.EscapeDataString(recipient)}";\n\n                HttpWebRequest request = (HttpWebRequest)WebRequest.Create(API_URL);\n                request.Method = "POST";\n                request.ContentType = "application/x-www-form-urlencoded";\n                request.Headers.Add("X-Zeepmobile-Date", http_date);\n                request.Headers.Add("Authorization", GenerateAuthorizationHeader(http_date));\n\n                byte[] byteArray = Encoding.UTF8.GetBytes(data);\n                request.ContentLength = byteArray.Length;\n                \n                using (Stream dataStream = request.GetRequestStream())\n                {\n                    dataStream.Write(byteArray, 0, byteArray.Length);\n                }\n\n                using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n                {\n                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))\n                    {\n                        string responseFromServer = reader.ReadToEnd();\n                        Console.WriteLine(responseFromServer);\n                    }\n                }\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("Exception caught: " + ex.Message);\n            }\n        }\n\n        static string GenerateAuthorizationHeader(string http_date)\n        {\n            string stringToSign = $"POST\n\napplication/x-www-form-urlencoded\n{http_date}\n/messaging/2008-07-14/blast_message";\n            byte[] secretKeyBytes = Encoding.UTF8.GetBytes(SECRET_ACCESS_KEY);\n            using (HMACSHA1 hmac = new HMACSHA1(secretKeyBytes))\n            {\n                byte[] signatureBytes = hmac.ComputeHash(Encoding.UTF8.GetBytes(stringToSign));\n                string signature = Convert.ToBase64String(signatureBytes);\n                return $"Zeep {API_KEY}:{signature}";\n            }\n        }\n    }\n}