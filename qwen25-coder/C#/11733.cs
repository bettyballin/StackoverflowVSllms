private void btnBrowse_Click(object sender, EventArgs e)\n{\n    using (var folderBrowserDialog = new FolderBrowserDialog())\n    {\n        if (folderBrowserDialog.ShowDialog() == DialogResult.OK)\n        {\n            string selectedPath = folderBrowserDialog.SelectedPath;\n            \n            // Perform operations with the selected path here\n            UpdateBackupLocation(selectedPath);\n        }\n    }\n\n    // Ensure all UI updates are completed before closing\n    this.Close();\n}\n\nprivate void UpdateBackupLocation(string path)\n{\n    // Example method to update backup location in a thread-safe manner\n    if (this.InvokeRequired)\n    {\n        this.Invoke(new Action<string>(UpdateBackupLocation), new object[] { path });\n    }\n    else\n    {\n        txtBackupPath.Text = path; // Assuming you have a TextBox named txtBackupPath\n    }\n}