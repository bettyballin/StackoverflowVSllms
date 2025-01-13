using System;\nusing System.IO;\nusing System.Threading.Tasks;\nusing System.Windows.Forms;\n\npublic partial class Form1 : Form\n{\n    public Form1()\n    {\n        InitializeComponent();\n    }\n\n    private async void button1_Click(object sender, EventArgs e)\n    {\n        await ProcessFilesAsync();\n    }\n\n    private async Task ProcessFilesAsync()\n    {\n        DirectoryInfo dir = new DirectoryInfo("path_to_your_directory");\n        int fileCount = dir.GetFiles("*.txt").Length;\n        int progress = 0;\n\n        foreach (FileInfo f in dir.GetFiles("*.txt"))\n        {\n            // Do processing\n            // Simulate processing with delay\n            await Task.Delay(1000);\n\n            progress++;\n            int percentage = (progress * 100) / fileCount;\n\n            // Update UI\n            label1.Text = $"{f.Name} is done processing, now processing...";\n            progressBar1.Value = percentage;\n\n            // Force UI update\n            Application.DoEvents();\n        }\n\n        label1.Text = "Processing completed.";\n        progressBar1.Value = 100;\n    }\n}