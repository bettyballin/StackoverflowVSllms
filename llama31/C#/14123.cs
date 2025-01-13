// Assuming you have a list of control metadata\nList<ControlMetadata> controls = ...;\n\nforeach (ControlMetadata control in controls)\n{\n    Control ctrl = null;\n    switch (control.Type)\n    {\n        case "textbox":\n            ctrl = new TextBox();\n            break;\n        case "calendar":\n            ctrl = new Calendar();\n            break;\n        case "dropdownlist":\n            ctrl = new DropDownList();\n            break;\n    }\n\n    // Add validation controls based on the control type and flag\n    if (control.RequiresValidation)\n    {\n        if (control.Type == "textbox")\n        {\n            RequiredFieldValidator validator = new RequiredFieldValidator();\n            validator.ControlToValidate = ctrl.ID;\n            validator.ErrorMessage = "Field is required";\n            validator.Display = ValidatorDisplay.Dynamic;\n            page.Controls.Add(validator);\n        }\n        else if (control.Type == "calendar")\n        {\n            RangeValidator validator = new RangeValidator();\n            validator.ControlToValidate = ctrl.ID;\n            validator.MinimumValue = DateTime.MinValue.ToString();\n            validator.MaximumValue = DateTime.MaxValue.ToString();\n            validator.ErrorMessage = "Invalid date range";\n            validator.Display = ValidatorDisplay.Dynamic;\n            page.Controls.Add(validator);\n        }\n        // Add more validation rules as needed\n    }\n\n    page.Controls.Add(ctrl);\n}