using System;\nusing System.Collections.Generic;\nusing System.Web.UI.WebControls;\n\npublic partial class _Default : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            // Initial load logic if any\n        }\n    }\n\n    protected void btnSubmit_Click(object sender, EventArgs e)\n    {\n        List<string> dropdownValues = new List<string>();\n        foreach (ListItem item in ddlExample.Items)\n        {\n            dropdownValues.Add(item.Value);\n        }\n\n        // Now you have all dropdown values in dropdownValues list\n        // You can process these values as required\n    }\n}