public class ValidationErrorBehavior\n{\n    public static ICommand GetCommand(DependencyObject obj)\n    {\n        return (ICommand)obj.GetValue(CommandProperty);\n    }\n\n    public static void SetCommand(DependencyObject obj, ICommand value)\n    {\n        obj.SetValue(CommandProperty, value);\n    }\n\n    public static readonly DependencyProperty CommandProperty =\n        DependencyProperty.RegisterAttached("Command", typeof(ICommand), typeof(ValidationErrorBehavior), new PropertyMetadata(null, OnCommandChanged));\n\n    private static void OnCommandChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)\n    {\n        FrameworkElement element = d as FrameworkElement;\n        if (element != null)\n        {\n            element.AddHandler(Validation.ErrorEvent, new RoutedEventHandler(OnError));\n        }\n    }\n\n    private static void OnError(object sender, RoutedEventArgs e)\n    {\n        ValidationErrorEventArgs args = e as ValidationErrorEventArgs;\n        if (args != null)\n        {\n            ICommand command = GetCommand(sender as DependencyObject);\n            if (command != null)\n            {\n                command.Execute(args.Error);\n            }\n        }\n    }\n}