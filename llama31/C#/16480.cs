using ScintillaNET;\n\npublic partial class Form1 : Form\n{\n    private Scintilla scintilla;\n\n    public Form1()\n    {\n        InitializeComponent();\n\n        scintilla = new Scintilla();\n        scintilla.Dock = DockStyle.Fill;\n        this.Controls.Add(scintilla);\n    }\n}