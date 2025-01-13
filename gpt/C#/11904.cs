using System;\nusing System.Linq;\n\npublic static class LinqExtensions\n{\n    public static int SafeSum<TSource>(this IQueryable<TSource> source, Func<TSource, int> selector)\n    {\n        return source.Select(selector).Sum() ?? 0;\n    }\n}