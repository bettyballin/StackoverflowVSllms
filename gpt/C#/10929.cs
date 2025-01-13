using System;\nusing System.Text;\nusing System.Windows.Forms;\n\npublic class Form1 : Form\n{\n    private TextBox textBox1;\n\n    public Form1()\n    {\n        textBox1 = new TextBox();\n        textBox1.Multiline = true;\n        textBox1.Dock = DockStyle.Fill;\n        textBox1.KeyDown += new KeyEventHandler(TextBox1_KeyDown);\n        Controls.Add(textBox1);\n    }\n\n    private void TextBox1_KeyDown(object sender, KeyEventArgs e)\n    {\n        if (e.Control && e.KeyCode == Keys.V)\n        {\n            e.SuppressKeyPress = true; // Prevent default paste behavior\n            IDataObject data = Clipboard.GetDataObject();\n            if (data != null && data.GetDataPresent(DataFormats.Text))\n            {\n                string clipboardText = data.GetData(DataFormats.Text).ToString();\n                byte[] ansiBytes = Encoding.Default.GetBytes(clipboardText);\n                string ansiText = Encoding.Default.GetString(ansiBytes);\n                textBox1.Paste(ansiText);\n            }\n        }\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new Form1());\n    }\n}