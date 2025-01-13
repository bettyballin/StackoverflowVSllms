using System;\nusing System.Web;\n\npublic partial class _Default : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        // Retrieve the value of "somevariable" from the query string\n        string someVariableValue = Request.QueryString["somevariable"];\n        \n        // Check if the variable exists and has a value\n        if (!string.IsNullOrEmpty(someVariableValue))\n        {\n            // Use the value of the variable\n            Response.Write("The value of 'somevariable' is: " + someVariableValue);\n        }\n        else\n        {\n            Response.Write("'somevariable' is not present in the query string.");\n        }\n    }\n}