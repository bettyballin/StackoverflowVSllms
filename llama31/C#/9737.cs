public static IEnumerable<T> Sort<T>(this IEnumerable<T> source, string sortExpression, bool desc)\n{\n    var param = Expression.Parameter(typeof(T), string.Empty);\n    try\n    {\n        var property = GetPropertyExpression(param, sortExpression);\n        var sortLambda = Expression.Lambda<Func<T, object>>(Expression.Convert(property, typeof(object)), param);\n\n        if (desc)\n        {\n            return source.AsQueryable<T>().OrderByDescending<T, object>(sortLambda);\n        }\n\n        return source.AsQueryable<T>().OrderBy<T, object>(sortLambda);\n    }\n    catch (ArgumentException)\n    {\n        return source;\n    }\n}\n\nprivate static Expression GetPropertyExpression(Expression param, string sortExpression)\n{\n    var properties = sortExpression.Split('.');\n    Expression property = param;\n    foreach (var prop in properties)\n    {\n        property = Expression.Property(property, prop);\n    }\n    return property;\n}