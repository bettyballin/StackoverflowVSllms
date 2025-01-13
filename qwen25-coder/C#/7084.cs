public class ComboBoxValidationRule : ValidationRule\n{\n    public string ErrorMessage { get; set; }\n\n    public override ValidationResult Validate(object value, CultureInfo cultureInfo)\n    {\n        if (value == null || value.Equals(-1)) // Adjust based on how your binding works\n        {\n            return new ValidationResult(false, this.ErrorMessage);\n        }\n        else\n        {\n            return ValidationResult.ValidResult;\n        }\n    }\n}