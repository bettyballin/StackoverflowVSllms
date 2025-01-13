using System;\nusing System.Net;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string url = "http://example.com";\n        string contentType = GetContentType(url);\n        \n        if (contentType != null)\n        {\n            if (contentType.Contains("text/html"))\n            {\n                Console.WriteLine("The URL points to an HTML file.");\n            }\n            else if (contentType.Contains("application/xml") || contentType.Contains("text/xml"))\n            {\n                Console.WriteLine("The URL points to an XML file.");\n            }\n            else\n            {\n                Console.WriteLine("The content type is: " + contentType);\n            }\n        }\n        else\n        {\n            Console.WriteLine("Unable to determine the content type.");\n        }\n    }\n\n    public static string GetContentType(string url)\n    {\n        try\n        {\n            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n            request.Method = "HEAD";\n            \n            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n            {\n                return response.ContentType;\n            }\n        }\n        catch (WebException ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n            return null;\n        }\n    }\n}