using System;\nusing System.Web.UI.HtmlControls;\n\nnamespace YourNamespace\n{\n    public partial class Editor : System.Web.UI.Page\n    {\n        protected void Page_Load(object sender, EventArgs e)\n        {\n            string view = Request.QueryString["view"];\n            \n            if (!string.IsNullOrEmpty(view))\n            {\n                HtmlGenericControl list = new HtmlGenericControl("ul");\n                list.ID = "editor-menu";\n\n                HtmlGenericControl listItem = new HtmlGenericControl("li");\n                listItem.InnerText = "List Item 1";\n\n                list.Controls.Add(listItem);\n                dynamicContent.Controls.Add(list);\n            }\n        }\n    }\n}