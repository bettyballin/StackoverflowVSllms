using System;\nusing System.Text;\nusing System.Web;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string encodedVar = "Q29weXJpZ2h0IMKpIDIwMjMgVHJhZGVtYXJrIMKp"; // Example base64 string, replace with your own\n        string decodedVar = Base64Decode(encodedVar);\n        Console.WriteLine(decodedVar);\n    }\n\n    public static string Base64Decode(string data)\n    {\n        try\n        {\n            // Replace spaces with plus signs\n            data = data.Replace(" ", "+");\n\n            // Decode from base64\n            byte[] toDecodeByte = Convert.FromBase64String(data);\n            string result = Encoding.UTF8.GetString(toDecodeByte);\n            return result;\n        }\n        catch (Exception e)\n        {\n            throw new Exception("Error in base64Decode: " + e.Message);\n        }\n    }\n}