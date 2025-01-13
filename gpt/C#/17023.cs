public class FirstNameValidationRule : ValidationRule\n{\n    public override ValidationResult Validate(object value, System.Globalization.CultureInfo cultureInfo)\n    {\n        if (value == null || string.IsNullOrEmpty(value.ToString()))\n        {\n            return new ValidationResult(false, "FirstName cannot be null or empty!");\n        }\n        return ValidationResult.ValidResult;\n    }\n}