using System;\nusing System.Windows.Forms;\n\npublic class AjaxMonitorForm : Form\n{\n    private WebBrowser webBrowser;\n    private Timer timer;\n    private string lastHtmlContent;\n\n    public AjaxMonitorForm()\n    {\n        webBrowser = new WebBrowser();\n        webBrowser.Dock = DockStyle.Fill;\n        webBrowser.DocumentCompleted += WebBrowser_DocumentCompleted;\n        this.Controls.Add(webBrowser);\n\n        timer = new Timer();\n        timer.Interval = 1000; // Check every second\n        timer.Tick += Timer_Tick;\n\n        webBrowser.Navigate("http://your-ajax-page-url.com");\n    }\n\n    private void WebBrowser_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)\n    {\n        lastHtmlContent = webBrowser.Document.Body.InnerHtml;\n        timer.Start();\n    }\n\n    private void Timer_Tick(object sender, EventArgs e)\n    {\n        string currentHtmlContent = webBrowser.Document.Body.InnerHtml;\n        if (currentHtmlContent != lastHtmlContent)\n        {\n            OnAjaxUpdateDetected();\n            lastHtmlContent = currentHtmlContent;\n        }\n    }\n\n    private void OnAjaxUpdateDetected()\n    {\n        // Handle the AJAX update event here\n        MessageBox.Show("AJAX content updated!");\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.Run(new AjaxMonitorForm());\n    }\n}