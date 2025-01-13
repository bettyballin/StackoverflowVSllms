protected void Page_Load(object sender, EventArgs e)\n{\n    // Example configuration settings\n    string controlsToValidate = "NameTextBox,AddressTextBox,EmailTextBox";\n    string[] controlsArray = controlsToValidate.Split(',');\n\n    foreach (string controlID in controlsArray)\n    {\n        Control control = FindControl(controlID);\n        if (control != null && control is TextBox)\n        {\n            RequiredFieldValidator validator = new RequiredFieldValidator();\n            validator.ControlToValidate = controlID;\n            validator.ErrorMessage = controlID + " is required.";\n            validator.Display = ValidatorDisplay.Dynamic;\n            validator.EnableClientScript = true;\n\n            // Add the validator to the page\n            this.Form.Controls.Add(validator);\n\n            // Optional: Attach the ValidatorCalloutExtender if needed\n            ValidatorCalloutExtender calloutExtender = new ValidatorCalloutExtender();\n            calloutExtender.TargetControlID = validator.ID;\n            calloutExtender.ID = "ValidatorCalloutExtender_" + controlID;\n            calloutExtender.HighlightCssClass = "highlight";\n\n            // Add the callout extender to the page\n            this.Form.Controls.Add(calloutExtender);\n        }\n    }\n}