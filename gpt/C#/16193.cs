using System;\nusing System.Globalization;\nusing System.Windows;\nusing System.Windows.Data;\n\nnamespace YourNamespace\n{\n    public class InvertedBooleanToVisibilityConverter : IValueConverter\n    {\n        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n        {\n            if (value is bool booleanValue)\n            {\n                return booleanValue ? Visibility.Collapsed : Visibility.Visible;\n            }\n            return Visibility.Visible;\n        }\n\n        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n        {\n            if (value is Visibility visibility)\n            {\n                return visibility != Visibility.Visible;\n            }\n            return false;\n        }\n    }\n}