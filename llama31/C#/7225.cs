using System.Windows;\n\npublic class MyWindow : Window\n{\n    public MyWindow()\n    {\n        Title = "My WPF Window";\n        Width = 400;\n        Height = 300;\n        Content = new TextBlock { Text = "Hello, World!" };\n    }\n}