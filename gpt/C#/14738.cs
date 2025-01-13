using System;\nusing System.Windows.Forms;\n\npublic partial class MainForm : Form\n{\n    public MainForm()\n    {\n        InitializeComponent();\n        myUserControl1.ValidationErrorOccurred += MyUserControl1_ValidationErrorOccurred;\n    }\n\n    private void MyUserControl1_ValidationErrorOccurred(object sender, string e)\n    {\n        // Assuming statusBar is a StatusStrip control in the main form\n        statusBar.Text = e;\n    }\n}