using CefSharp;\nusing CefSharp.WinForms;\n\nnamespace MyWinFormsApp\n{\n    public partial class MainForm : Form\n    {\n        private ChromiumWebBrowser _browser;\n\n        public MainForm()\n        {\n            InitializeComponent();\n\n            _browser = new ChromiumWebBrowser("https://www.example.com");\n            _browser.Dock = DockStyle.Fill;\n            this.Controls.Add(_browser);\n        }\n    }\n}