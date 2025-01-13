using System;\nusing System.Windows.Forms;\n\npublic partial class MainForm : Form\n{\n    private WebBrowser webBrowser;\n\n    public MainForm()\n    {\n        InitializeComponent();\n        webBrowser = new WebBrowser();\n        webBrowser.ObjectForScripting = this; // Set the object for scripting\n        webBrowser.Navigate("http://your-login-page.com");\n    }\n\n    // This method will be called from the web page\n    public void ReceiveFilePath(string filePath)\n    {\n        // Do something with the file path\n        Console.WriteLine("Received file path: " + filePath);\n    }\n}