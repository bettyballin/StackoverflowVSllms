public interface ISomething\n{\n    // Define methods and properties for the interface\n}\n\npublic class SpecialTextBox : TextBox, ISomething\n{\n    // Implementation of ISomething methods and properties\n}\n\npublic class SpecialDatePicker : DatePicker, ISomething\n{\n    // Implementation of ISomething methods and properties\n}\n\n// Declare a variable of type Control which also implements ISomething\nControl control = new SpecialTextBox();\nISomething something = (ISomething)control;