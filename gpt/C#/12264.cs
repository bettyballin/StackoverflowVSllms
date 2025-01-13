using System;\nusing System.Net;\n\npublic class ImageChecker\n{\n    public static bool ImageExists(string url)\n    {\n        try\n        {\n            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n            request.Method = "HEAD"; // Use HEAD to just get the headers\n            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())\n            {\n                return response.StatusCode == HttpStatusCode.OK;\n            }\n        }\n        catch (WebException ex)\n        {\n            if (ex.Response is HttpWebResponse response)\n            {\n                return response.StatusCode == HttpStatusCode.OK;\n            }\n            return false;\n        }\n    }\n\n    public static void Main()\n    {\n        string imageUrl = "http://yourwebsite.com/media/1/image.jpg";\n        bool exists = ImageExists(imageUrl);\n        if (exists)\n        {\n            Console.WriteLine("Image exists.");\n        }\n        else\n        {\n            Console.WriteLine("Image does not exist.");\n        }\n    }\n}