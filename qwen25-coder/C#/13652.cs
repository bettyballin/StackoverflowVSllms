public static T? GetValueOrDefault<T>(this IDataReader reader, int index) where T : struct\n{\n    var value = reader.GetValue(index);\n    if (value == DBNull.Value)\n    {\n        return null;\n    }\n    return (T?)Convert.ChangeType(value, typeof(T));\n}\n\npublic static string GetString(this IDataReader reader, int index)\n{\n    var value = reader.GetValue(index);\n    if (value == DBNull.Value || value == null)\n    {\n        return null;\n    }\n    return Convert.ToString(value);\n}