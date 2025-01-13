using DevExpress.Xpf.RichEdit;\n\npublic partial class MainWindow : Window\n{\n    public MainWindow()\n    {\n        InitializeComponent();\n\n        var editor = new RichEditControl();\n        editor.Dock = Dock.Top;\n        editor.ActiveViewType = RichEditViewType.Html;\n\n        // Configure table support\n        editor.Options.Tables.AllowInsertTable = true;\n        editor.Options.Tables.AllowMergeCells = true;\n\n        // Add the editor to the window\n        this.Content = editor;\n    }\n}