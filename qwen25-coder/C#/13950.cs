public class ValidationSummaryConverter : IValueConverter\n{\n    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        var observable = (INotifyDataErrorInfo)value;\n        if (!observable.HasErrors) return null;\n\n        var results = new List<string>();\n\n        foreach (var property in observable.GetType().GetProperties())\n            foreach (var error in observable.GetErrors(property.Name) as IEnumerable<string> ?? Enumerable.Empty<string>())\n                results.Add(error);\n\n        return results.Distinct();\n    }\n\n    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        throw new NotImplementedException();\n    }\n}