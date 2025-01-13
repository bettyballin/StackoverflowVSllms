using log4net;\nusing System.Reflection;\n\npublic class ValidationContext\n{\n    private static readonly ILog log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);\n    public List<ValidationException> Exceptions { get; } = new List<ValidationException>();\n\n    public void LogExceptions()\n    {\n        foreach (var ex in Exceptions)\n        {\n            log.Error(ex.Message, ex);\n        }\n    }\n}\n\n// Modify Validate method to catch exceptions\npublic void Validate(Table table, ValidationContext context)\n{\n    foreach (var validation in _validations)\n    {\n        try\n        {\n            validation.Validate(table);\n        }\n        catch (ValidationException ex)\n        {\n            context.Exceptions.Add(ex);\n        }\n    }\n}\n\n// Example usage with context\npublic static void Main()\n{\n    // Initialize log4net\n    log4net.Config.XmlConfigurator.Configure();\n\n    var context = new ValidationContext();\n\n    // Validate tables\n    compositeValidation1.Validate(table1, context);\n    compositeValidation2.Validate(table2, context);\n\n    // Log all exceptions at the end\n    context.LogExceptions();\n}