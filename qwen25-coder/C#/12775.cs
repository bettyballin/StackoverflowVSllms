using System.Web.UI.WebControls;\n\n   namespace Namespace\n   {\n       public partial class MyControl : TableRow\n       {\n           protected void Page_Load(object sender, EventArgs e)\n           {\n               // Initialization code can go here if needed.\n           }\n\n           public void SetData(string column1Data, string column2Data)\n           {\n               Cells[0].Text = column1Data;\n               Cells[1].Text = column2Data;\n           }\n       }\n   }