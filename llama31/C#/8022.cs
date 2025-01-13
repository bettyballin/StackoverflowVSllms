public class ValidationResult\n{\n    public bool IsValid { get; set; }\n    public List<string> ErrorMessages { get; set; }\n\n    public ValidationResult(bool isValid, List<string> errorMessages = null)\n    {\n        IsValid = isValid;\n        ErrorMessages = errorMessages ?? new List<string>();\n    }\n}\n\npublic class PersonServices\n{\n    public ValidationResult AddPerson(Person person)\n    {\n        var validationResult = new ValidationResult(true);\n\n        if (string.IsNullOrEmpty(person.FirstName) || string.IsNullOrEmpty(person.LastName))\n        {\n            validationResult.IsValid = false;\n            validationResult.ErrorMessages.Add("First name and last name are required.");\n        }\n\n        // Additional validation checks...\n\n        if (validationResult.IsValid)\n        {\n            // Save the person to the repository\n        }\n\n        return validationResult;\n    }\n}