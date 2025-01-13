using System;\n\nnamespace YourNamespace\n{\n    public partial class Add : System.Web.UI.Page\n    {\n        protected void Page_Load(object sender, EventArgs e)\n        {\n            if (!IsPostBack)\n            {\n                LoadControlBasedOnQueryString();\n            }\n        }\n\n        private void LoadControlBasedOnQueryString()\n        {\n            string type = Request.QueryString["type"];\n            if (string.IsNullOrEmpty(type)) return;\n\n            string controlPath = $"~/UserControls/Add{type}.ascx";\n            var control = LoadControl(controlPath);\n            phControls.Controls.Add(control);\n        }\n    }\n}