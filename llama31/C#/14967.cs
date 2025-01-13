public static IEnumerable ForEach(this IEnumerable enumerable, Action<object> action)\n{\n    foreach (var item in enumerable)\n    {\n        action(item);\n    }\n    return enumerable;\n}