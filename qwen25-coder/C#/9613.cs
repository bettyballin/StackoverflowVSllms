public partial class ErrorDialog : Form\n   {\n       public string ErrorMessage { get; set; }\n\n       public ErrorDialog(string message)\n       {\n           InitializeComponent();\n           this.ErrorMessage = message;\n           txtErrorMessage.Text = message;\n       }\n   }