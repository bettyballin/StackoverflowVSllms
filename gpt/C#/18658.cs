private delegate void UpdateTextBoxDelegate(string value);\n\nprivate void UpdateTextBox(string value)\n{\n    if (this.txtPrice.InvokeRequired)\n    {\n        // If the current thread is not the UI thread, invoke the method on the UI thread.\n        this.txtPrice.Invoke(new UpdateTextBoxDelegate(UpdateTextBox), value);\n    }\n    else\n    {\n        // Otherwise, we are on the UI thread already.\n        this.txtPrice.Text = value;\n    }\n}