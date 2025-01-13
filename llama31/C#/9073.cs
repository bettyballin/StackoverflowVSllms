using System;\nusing System.Net;\nusing System.Text;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Web;\n\nclass Program\n{\n    public static string API_KEY = "MY_API_KEY";\n    public static string SECRET_ACCESS_KEY = "MY_SECRET_KEY";\n    public static string PATTERN_RFC1123 = "ddd, dd MMM yyyy HH:mm:ss " + "GMT";\n\n    static void Main(string[] args)\n    {\n        string apiurl = "https://api.zeepmobile.com/messaging/2008-07-14/blast_message";\n        string http_date = DateTime.UtcNow.ToString("r");\n        string body = HttpUtility.UrlEncode("Test message.", Encoding.UTF8);\n        string parameters = "body=" + body;\n\n        string canonicalString = API_KEY + http_date + parameters;\n        HMACSHA1 hmacsha1 = new HMACSHA1(Encoding.UTF8.GetBytes(SECRET_ACCESS_KEY));\n        byte[] hashValue = hmacsha1.ComputeHash(Encoding.UTF8.GetBytes(canonicalString));\n        string b64Mac = Convert.ToBase64String(hashValue);\n        string authentication = string.Format("Zeep {0}:{1}", API_KEY, b64Mac);\n\n        HttpWebRequest request = (HttpWebRequest)WebRequest.Create(apiurl);\n        request.Method = "POST";\n        request.Headers.Add("Authorization", authentication);\n        request.Headers.Add("Date", http_date);\n        request.ContentType = "application/x-www-form-urlencoded";\n        request.ContentLength = parameters.Length;\n\n        using (StreamWriter writer = new StreamWriter(request.GetRequestStream()))\n        {\n            writer.Write(parameters);\n        }\n\n        HttpWebResponse response = (HttpWebResponse)request.GetResponse();\n        Console.WriteLine(response.StatusDescription);\n    }\n}