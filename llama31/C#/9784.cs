public static class ListExtensions\n{\n    public static bool CustomContains<T>(this List<T> list, T item)\n    {\n        // Your custom implementation here\n        // For example:\n        return list.Any(i => i.Equals(item));\n    }\n}