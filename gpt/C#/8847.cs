using System;\n   using System.Windows.Forms;\n   using BusinessLogic;\n\n   namespace WinFormsApp\n   {\n       public partial class MainForm : Form\n       {\n           public MainForm()\n           {\n               InitializeComponent();\n           }\n\n           private void btnGreet_Click(object sender, EventArgs e)\n           {\n               var logic = new MyBusinessLogic();\n               string greeting = logic.GetGreeting(txtName.Text);\n               MessageBox.Show(greeting);\n           }\n       }\n   }