using System;\nusing System.Globalization;\nusing System.Windows;\nusing System.Windows.Data;\n\npublic class StringToVisibilityConverter : IValueConverter\n{\n    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        return string.IsNullOrEmpty((value as string)) ? Visibility.Collapsed : Visibility.Visible;\n    }\n\n    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        throw new NotImplementedException();\n    }\n}