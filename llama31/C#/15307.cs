public static class GridHelpers\n{\n    public static readonly DependencyProperty RowCountProperty =\n        DependencyProperty.RegisterAttached("RowCount", typeof(int), typeof(GridHelpers), new PropertyMetadata(0, OnRowCountChanged));\n\n    public static readonly DependencyProperty ColumnCountProperty =\n        DependencyProperty.RegisterAttached("ColumnCount", typeof(int), typeof(GridHelpers), new PropertyMetadata(0, OnColumnCountChanged));\n\n    public static int GetRowCount(DependencyObject obj)\n    {\n        return (int)obj.GetValue(RowCountProperty);\n    }\n\n    public static void SetRowCount(DependencyObject obj, int value)\n    {\n        obj.SetValue(RowCountProperty, value);\n    }\n\n    public static int GetColumnCount(DependencyObject obj)\n    {\n        return (int)obj.GetValue(ColumnCountProperty);\n    }\n\n    public static void SetColumnCount(DependencyObject obj, int value)\n    {\n        obj.SetValue(ColumnCountProperty, value);\n    }\n\n    private static void OnRowCountChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)\n    {\n        Grid grid = (Grid)d;\n        grid.RowDefinitions.Clear();\n        for (int i = 0; i < (int)e.NewValue; i++)\n        {\n            grid.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });\n        }\n    }\n\n    private static void OnColumnCountChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)\n    {\n        Grid grid = (Grid)d;\n        grid.ColumnDefinitions.Clear();\n        for (int i = 0; i < (int)e.NewValue; i++)\n        {\n            grid.ColumnDefinitions.Add(new ColumnDefinition { Width = new GridLength(1, GridUnitType.Star) });\n        }\n    }\n}