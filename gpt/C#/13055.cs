using System;\nusing System.Web.UI;\n\nnamespace YourNamespace\n{\n    public partial class YourPage : Page\n    {\n        protected void Page_Load(object sender, EventArgs e)\n        {\n        }\n\n        protected void btnDelete_Click(object sender, EventArgs e)\n        {\n            bool confirmResult = Convert.ToBoolean(hdnConfirmResult.Value);\n            if (confirmResult)\n            {\n                // Add your deletion logic here\n            }\n            else\n            {\n                // User canceled the operation\n            }\n        }\n    }\n}