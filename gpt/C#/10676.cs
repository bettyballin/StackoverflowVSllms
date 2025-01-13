// AddNewUser.aspx.cs\nusing System;\nusing System.Collections.Generic;\n\npublic partial class AddNewUser : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n    }\n\n    protected void btnSave_Click(object sender, EventArgs e)\n    {\n        List<string> errors = ValidateUserInput();\n        if (errors.Count > 0)\n        {\n            ((MasterPage)this.Master).DisplayErrors(errors);\n        }\n        else\n        {\n            // Proceed with saving user data\n        }\n    }\n\n    private List<string> ValidateUserInput()\n    {\n        List<string> errors = new List<string>();\n\n        // Perform validation here and add error messages to the list\n        if (string.IsNullOrEmpty(txtUsername.Text))\n        {\n            errors.Add("Username is required.");\n        }\n\n        if (string.IsNullOrEmpty(txtPassword.Text))\n        {\n            errors.Add("Password is required.");\n        }\n\n        // Add more validation as needed\n\n        return errors;\n    }\n}