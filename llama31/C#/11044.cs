public class ValidationResult\n{\n    public bool IsValid { get; set; }\n    public List<string> ErrorMessages { get; set; }\n}\n\npublic interface IValidator\n{\n    ValidationResult Validate(InputData inputData);\n}\n\npublic class Validator : IValidator\n{\n    public ValidationResult Validate(InputData inputData)\n    {\n        // Perform validation logic here\n        // Return a ValidationResult object with error messages\n    }\n}\n\npublic class FireTheMisslesService\n{\n    private readonly IValidator _validator;\n\n    public FireTheMisslesService(IValidator validator)\n    {\n        _validator = validator;\n    }\n\n    public void FireTheMissles(InputData inputData)\n    {\n        ValidationResult result = _validator.Validate(inputData);\n        if (!result.IsValid)\n        {\n            // Handle validation errors here\n            // You can throw an exception or return an error code\n        }\n        // Proceed with firing the missiles\n    }\n}\n\npublic class GUI\n{\n    private readonly FireTheMisslesService _service;\n    private readonly IValidator _validator;\n\n    public GUI(FireTheMisslesService service, IValidator validator)\n    {\n        _service = service;\n        _validator = validator;\n    }\n\n    public void ButtonClickHandler(InputData inputData)\n    {\n        ValidationResult result = _validator.Validate(inputData);\n        if (!result.IsValid)\n        {\n            // Display error messages to the user\n        }\n        else\n        {\n            _service.FireTheMissles(inputData);\n        }\n    }\n}