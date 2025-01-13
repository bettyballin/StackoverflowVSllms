public static class XmlExtensions\n{\n    public static T SafeNavigate<T>(this T obj, Func<T, T> action) where T : XElement\n    {\n        return obj == null ? default(T) : action(obj);\n    }\n}