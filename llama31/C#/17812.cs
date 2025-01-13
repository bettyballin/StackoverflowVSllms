using System.Windows.Forms;\nusing System.IO;\n\n// ...\n\nprivate void btnSaveAs_Click(object sender, EventArgs e)\n{\n    string dataToSave = "Your string data here"; // replace with your string data\n\n    SaveFileDialog saveFileDialog = new SaveFileDialog();\n    saveFileDialog.Filter = "CSV files (*.csv)|*.csv";\n    saveFileDialog.Title = "Save as CSV file";\n    saveFileDialog.ShowDialog();\n\n    if (saveFileDialog.FileName != "")\n    {\n        File.WriteAllText(saveFileDialog.FileName, dataToSave);\n    }\n}