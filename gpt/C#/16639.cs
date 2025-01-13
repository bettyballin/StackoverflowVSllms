using System;\nusing System.Globalization;\nusing System.Windows;\nusing System.Windows.Data;\n\npublic class BoolToVisibilityConverter : IValueConverter\n{\n    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        if (value is bool boolValue)\n        {\n            return boolValue ? Visibility.Visible : Visibility.Hidden;\n        }\n        return Visibility.Hidden;\n    }\n\n    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        throw new NotImplementedException();\n    }\n}