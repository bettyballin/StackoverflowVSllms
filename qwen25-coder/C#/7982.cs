public class BoolColorConverter : IValueConverter\n{\n    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        if (value is bool b && b)\n            return new SolidColorBrush(Colors.Green); // Assuming On=true means Green else default.\n\n        return new SolidColorBrush(Colors.Red);\n    }\n\n    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n    {\n        throw new NotImplementedException();\n    }\n}