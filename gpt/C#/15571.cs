using System;\nusing System.Web.UI.WebControls;\n\nnamespace YourNamespace\n{\n    public partial class Validation : System.Web.UI.Page\n    {\n        protected void Page_Load(object sender, EventArgs e)\n        {\n\n        }\n\n        protected void cvName_ServerValidate(object source, ServerValidateEventArgs args)\n        {\n            args.IsValid = !string.IsNullOrEmpty(txtName.Text);\n        }\n\n        protected void btnSubmit_Click(object sender, EventArgs e)\n        {\n            if (Page.IsValid)\n            {\n                // Proceed with your logic here\n            }\n        }\n    }\n}