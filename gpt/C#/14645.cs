public static bool IsEmpty<T>(this IEnumerable<T> list)\n{\n    if (list is ICollection<T> collection)\n    {\n        return collection.Count == 0;\n    }\n    return !list.Any();\n}