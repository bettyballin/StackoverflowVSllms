using System.Windows.Forms;\n\npublic class WebAppForm : Form\n{\n    public WebAppForm()\n    {\n        this.Text = "Embedded Web Application Example";\n        this.Width = 800;\n        this.Height = 600;\n\n        WebBrowser webView = new WebBrowser();\n        webView.Dock = DockStyle.Fill;\n        webView.Navigate("https://www.example.com/");\n\n        this.Controls.Add(webView);\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new WebAppForm());\n    }\n}