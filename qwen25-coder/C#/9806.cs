public partial class MainForm : Form\n{\n    public MainForm()\n    {\n        InitializeComponent();\n\n        myUserControl.ValidationErrorOccurred += OnValidationError;\n    }\n\n    private void OnValidationError(object sender, string errorMessage)\n    {\n        // Assuming you have a StatusBar or StatusStrip named statusBar in your form\n        statusBar.Text = errorMessage;\n    }\n}