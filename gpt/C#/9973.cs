using System;\nusing System.Web.UI;\n\nnamespace YourNamespace\n{\n    public partial class YourPage : Page\n    {\n        protected void Page_Load(object sender, EventArgs e)\n        {\n        }\n\n        protected void btnSubmit_Click(object sender, EventArgs e)\n        {\n            // Your logic here\n            lblMessage.Text = "Save Successful";\n        }\n    }\n}