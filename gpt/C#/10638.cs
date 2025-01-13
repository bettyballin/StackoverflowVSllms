using System;\nusing System.Windows.Forms;\n\npublic class Form1 : Form\n{\n    private TextBox textBox;\n\n    public Form1()\n    {\n        textBox = new TextBox();\n        textBox.Multiline = true;\n        textBox.Width = 200;\n        textBox.Height = 100;\n\n        this.Controls.Add(textBox);\n\n        string[] names = { "Ann", "Sarah", "Paul" };\n        int[] ages = { 26, 29, 45 };\n\n        string output = "";\n\n        for (int i = 0; i < names.Length; i++)\n        {\n            output += $"{names[i]}\t{ages[i]}\n";\n        }\n\n        textBox.Text = output;\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.Run(new Form1());\n    }\n}