public class MyDataObject : INotifyDataErrorInfo\n{\n    public event EventHandler<DataErrorsChangedEventArgs> ErrorsChanged;\n\n    public bool HasErrors => GetErrors(null).Cast<object>().Any();\n\n    public IEnumerable GetErrors(string propertyName)\n    {\n        // Your validation logic here\n        // Return a collection of errors\n    }\n\n    public void ValidateProperty(string propertyName)\n    {\n        // Raise the ErrorsChanged event before validating\n        ErrorsChanged?.Invoke(this, new DataErrorsChangedEventArgs(propertyName));\n\n        // Your validation logic here\n    }\n}