using System.Text.Json;\n   public static string SerializeObject(object obj)\n   {\n       return JsonSerializer.Serialize(obj);\n   }\n\n   public static T DeserializeObject<T>(string jsonString)\n   {\n       return JsonSerializer.Deserialize<T>(jsonString);\n   }