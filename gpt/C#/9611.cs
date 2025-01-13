public partial class MainForm : Form\n{\n    private KeyInterceptor _keyInterceptor;\n\n    public MainForm()\n    {\n        InitializeComponent();\n        _keyInterceptor = new KeyInterceptor(this.Handle);\n    }\n\n    protected override void WndProc(ref Message msg)\n    {\n        base.WndProc(ref msg);\n        _keyInterceptor.ProcessMessage(ref msg);\n    }\n}