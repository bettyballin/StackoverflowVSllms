using System;\nusing System.Globalization;\nusing System.Windows;\nusing System.Windows.Data;\n\npublic class BooleanToVisibilityConverter : IValueConverter\n{\n    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        if (value is bool boolValue)\n        {\n            // If parameter is set to "Invert", invert the logic\n            return (parameter as string) == "Invert" \n                   ? (!boolValue ? Visibility.Visible : Visibility.Collapsed) \n                   : (boolValue ? Visibility.Visible : Visibility.Collapsed);\n        }\n        return Visibility.Collapsed; // Default to collapsed if not a boolean\n    }\n\n    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        throw new NotImplementedException();\n    }\n}