using System;\nusing System.Windows.Forms;\n\n// ...\n\nprivate void buttonBrowse_Click(object sender, EventArgs e)\n{\n    using (FolderBrowserDialog dialog = new FolderBrowserDialog())\n    {\n        if (dialog.ShowDialog() == DialogResult.OK)\n        {\n            // do something with the selected folder path\n        }\n    }\n}