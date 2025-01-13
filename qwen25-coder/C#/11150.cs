using System;\nusing System.IO;\nusing System.Web.UI;\nusing System.Web.UI.WebControls;\n\npublic partial class YourPage : Page\n{\n    protected void ExportDataGridToHTML(DataGrid dataGrid)\n    {\n        // Ensure that the DataGrid is first bound to its data source\n        dataGrid.DataBind();\n\n        // Create a StringBuilder to hold the HTML output\n        using (StringWriter stringWriter = new StringWriter())\n        {\n            using (HtmlTextWriter htmlTextWriter = new HtmlTextWriter(stringWriter))\n            {\n                dataGrid.RenderControl(htmlTextWriter);\n                string htmlOutput = stringWriter.ToString();\n                \n                // Here you can use the htmlOutput as needed, e.g., save to a file or display\n                Response.Write("<pre>" + Server.HtmlEncode(htmlOutput) + "</pre>");\n            }\n        }\n    }\n\n    // Override VerifyRenderingInServerForm method if using inside an UpdatePanel or similar\n    public override void VerifyRenderingInServerForm(Control control)\n    {\n        // Confirms that an HtmlForm control is rendered for the specified ASP.NET server control \n        // at run time.\n    }\n}