public interface IRule\n{\n    bool IsValid(UIState state);\n}\n\npublic class RadioButtonTextBoxRule : IRule\n{\n    public bool IsValid(UIState state)\n    {\n        // Check if radiobutton is checked and textbox has text\n        // ...\n        return isValid;\n    }\n}\n\npublic class BusinessRulesEngine\n{\n    public IList<ValidationError> Validate(UIState state, IList<IRule> rules)\n    {\n        // Execute each rule and collect errors\n        // ...\n        return errors;\n    }\n}