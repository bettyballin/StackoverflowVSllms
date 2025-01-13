using System;\nusing System.Windows.Forms;\n\npublic class AutoCompleteForm : Form\n{\n    private TextBox textBox;\n    private AutoCompleteStringCollection autoCompleteCollection;\n\n    public AutoCompleteForm()\n    {\n        textBox = new TextBox\n        {\n            Location = new System.Drawing.Point(15, 15),\n            Width = 250\n        };\n\n        autoCompleteCollection = new AutoCompleteStringCollection();\n\n        textBox.AutoCompleteMode = AutoCompleteMode.SuggestAppend;\n        textBox.AutoCompleteSource = AutoCompleteSource.CustomSource;\n        textBox.AutoCompleteCustomSource = autoCompleteCollection;\n\n        // Subscribe to the TextChanged event to add new entries\n        textBox.TextChanged += TextBox_TextChanged;\n\n        Controls.Add(textBox);\n    }\n\n    private void TextBox_TextChanged(object sender, EventArgs e)\n    {\n        string currentText = textBox.Text;\n        if (!string.IsNullOrEmpty(currentText) && !autoCompleteCollection.Contains(currentText))\n        {\n            autoCompleteCollection.Add(currentText);\n        }\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new AutoCompleteForm());\n    }\n}