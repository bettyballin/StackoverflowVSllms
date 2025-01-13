using System;\nusing System.Web.UI;\nusing System.Web.UI.WebControls;\nusing System.Web.UI.ClientScriptManager;\n\npublic class AsyncUsernameValidator : BaseValidator\n{\n    protected override bool EvaluateIsValid()\n    {\n        // Server-side check (as a fallback or double-check)\n        string username = GetControlValidationValue(ControlToValidate);\n        return IsUsernameAvailable(username);\n    }\n\n    private bool IsUsernameAvailable(string username)\n    {\n        // Implement your logic to check username availability\n        // This could involve a database query or an API call.\n        // Return true if available, false otherwise.\n        return true;\n    }\n\n    protected override void OnPreRender(EventArgs e)\n    {\n        base.OnPreRender(e);\n        if (EnableClientScript)\n        {\n            RegisterClientSideScript();\n        }\n    }\n\n    private void RegisterClientSideScript()\n    {\n        string script = @"\n        <script type='text/javascript'>\n        function validateUsernameAvailability(source, args) {\n            var username = document.getElementById(source.controltovalidate).value;\n            // Perform AJAX call to check username availability\n            // Set args.IsValid = true if available, false otherwise\n        }\n        </script>";\n\n        if (!Page.ClientScript.IsClientScriptBlockRegistered("validateUsernameAvailability"))\n        {\n            Page.ClientScript.RegisterClientScriptBlock(this.GetType(), "validateUsernameAvailability", script);\n        }\n\n        string clientValidationFunction = "validateUsernameAvailability";\n        this.ClientValidationFunction = clientValidationFunction;\n    }\n}