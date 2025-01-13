public partial class MyWpfUserControl : UserControl\n{\n    public static readonly DependencyProperty IsValidProperty =\n        DependencyProperty.Register("IsValid", typeof(bool), typeof(MyWpfUserControl),\n            new PropertyMetadata(true, OnIsValidChanged));\n\n    private static void OnIsValidChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)\n    {\n        var control = (MyWpfUserControl)d;\n        control.IsValidChanged?.Invoke(control, EventArgs.Empty);\n    }\n\n    public event EventHandler IsValidChanged;\n\n    ...\n}