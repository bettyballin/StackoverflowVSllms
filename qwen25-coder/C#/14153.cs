using System;\nusing System.Threading.Tasks;\nusing System.Windows.Forms; // For Application.Current.Dispatcher if WPF, otherwise use Control.Invoke for WinForms\n\npublic class MyBho\n{\n    private WebBrowser webBrowser;\n\n    public void OnDocumentComplete(object pDisp, ref object URL)\n    {\n        // Ensure we're on the UI thread to access the DOM safely\n        if (webBrowser.InvokeRequired)\n        {\n            webBrowser.Invoke(new Action(() => OnDocumentComplete(pDisp, ref URL)));\n            return;\n        }\n\n        // Perform server communication asynchronously\n        Task.Run(async () =>\n        {\n            string result = await FetchDataFromServerAsync();\n\n            // Update the DOM on the UI thread after the asynchronous operation completes\n            if (webBrowser.InvokeRequired)\n            {\n                webBrowser.Invoke(new Action(() => UpdateDom(result)));\n            }\n            else\n            {\n                UpdateDom(result);\n            }\n        });\n    }\n\n    private async Task<string> FetchDataFromServerAsync()\n    {\n        // Simulate a time-consuming task, e.g., contacting a server\n        await Task.Delay(2000); // Represents network latency\n        return "Data from server";\n    }\n\n    private void UpdateDom(string data)\n    {\n        // Access and modify the DOM here\n        var document = webBrowser.Document;\n        document.Body.InnerText += $"\nServer Response: {data}";\n    }\n}