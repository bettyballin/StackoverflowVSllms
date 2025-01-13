public static class EnumerableExtensions\n{\n    public static void ForEach<T>(this IEnumerable<T> enumerable, Action<T> action)\n    {\n        foreach (T item in enumerable)\n        {\n            action(item);\n        }\n    }\n}