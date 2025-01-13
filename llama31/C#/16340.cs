public class CustomWordValidator : BaseValidator\n{\n    protected override bool EvaluateIsValid()\n    {\n        string input = ((TextBox)ControlToValidate).Text;\n        int numberWords = 2; // You can set this value as needed\n        string result = validateisMoreThanOneWord(input, numberWords);\n        return !string.IsNullOrEmpty(result);\n    }\n}