using System;\nusing System.Windows.Forms;\n\npublic class CustomFileDialog : Form\n{\n    private OpenFileDialog openFileDialog;\n    private Button btnSelectFile;\n\n    public CustomFileDialog()\n    {\n        openFileDialog = new OpenFileDialog();\n        btnSelectFile = new Button();\n        \n        btnSelectFile.Text = "Select";\n        btnSelectFile.Click += new EventHandler(BtnSelectFile_Click);\n        \n        this.Controls.Add(btnSelectFile);\n    }\n\n    private void BtnSelectFile_Click(object sender, EventArgs e)\n    {\n        if (openFileDialog.ShowDialog() == DialogResult.OK)\n        {\n            MessageBox.Show("File selected: " + openFileDialog.FileName);\n        }\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new CustomFileDialog());\n    }\n}