using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic static class ListExtensions\n{\n    private static Random _random = new Random();\n\n    public static List<T> GetRandomElements<T>(this List<T> list, int count)\n    {\n        if (list == null)\n        {\n            throw new ArgumentNullException(nameof(list));\n        }\n\n        if (count < 0 || count > list.Count)\n        {\n            throw new ArgumentOutOfRangeException(nameof(count));\n        }\n\n        return list.OrderBy(x => _random.Next()).Take(count).ToList();\n    }\n}