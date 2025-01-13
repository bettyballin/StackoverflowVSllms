public class UnitValidationAttribute : ValidationAttribute\n{\n    public string Unit { get; set; }\n    public int Min { get; set; }\n    public int Max { get; set; }\n\n    public override bool IsValid(object value)\n    {\n        // Get the selected unit from the dropdown\n        var unit = HttpContext.Current.Request.Form["unit"];\n\n        // Convert the input value to the selected unit\n        var convertedValue = ConvertValue(value, unit);\n\n        // Check if the converted value is within the limits\n        return convertedValue >= Min && convertedValue <= Max;\n    }\n\n    private int ConvertValue(object value, string unit)\n    {\n        // Implement the conversion logic here\n        // For example, if the unit is "hands", convert the value to cm\n        if (unit == "hands")\n        {\n            return (int)value * 20; // assume 1 hand = 20 cm\n        }\n        // Add more conversion logic for other units\n    }\n}