using System.Windows.Controls;\n\nnamespace YourNamespace\n{\n    public partial class MainPage : UserControl\n    {\n        public MainPage()\n        {\n            InitializeComponent();\n            webBrowser.Navigate(new Uri("http://www.example.com"));\n        }\n    }\n}