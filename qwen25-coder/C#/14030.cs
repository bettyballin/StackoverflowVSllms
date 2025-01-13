using System;\nusing System.Collections.Generic;\nusing System.Text.RegularExpressions;\nusing System.Windows.Forms;\n\npublic static class ValidationUtility\n{\n    public static List<string> ValidateControls(Control.ControlCollection controls)\n    {\n        var errors = new List<string>();\n\n        foreach (Control control in controls)\n        {\n            if (control is TextBox textBox && !string.IsNullOrEmpty(textBox.Tag?.ToString()))\n            {\n                switch (textBox.Tag.ToString().ToLower())\n                {\n                    case "zipcode":\n                        if (!IsValidZipCode(textBox.Text))\n                            errors.Add($"Invalid Zip Code: {textBox.Name}");\n                        break;\n                    // Add more cases for other validation rules\n                }\n            }\n\n            // Recursively validate child controls\n            if (control.HasChildren)\n            {\n                List<string> childErrors = ValidateControls(control.Controls);\n                errors.AddRange(childErrors);\n            }\n        }\n\n        return errors;\n    }\n\n    public static bool IsValidZipCode(string input)\n    {\n        // Example: US Zip Code validation using a regex pattern\n        string pattern = @"^\d{5}(-\d{4})?$";\n        Regex regex = new Regex(pattern);\n        return regex.IsMatch(input);\n    }\n}