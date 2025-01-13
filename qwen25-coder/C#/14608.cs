using System.Collections.Generic;\nusing System.ComponentModel;\n\npublic class ValidatableModel : INotifyPropertyChanged, INotifyDataErrorInfo\n{\n    private string _name;\n    public string Name\n    {\n        get { return _name; }\n        set\n        {\n            if (_name != value)\n            {\n                _name = value;\n                OnPropertyChanged(nameof(Name));\n                ValidateProperty(nameof(Name), value);\n            }\n        }\n    }\n\n    private readonly Dictionary<string, List<ValidationErrorInfo>> _errors =\n        new Dictionary<string, List<ValidationErrorInfo>>();\n\n    public bool HasErrors => _errors.Count > 0;\n\n    public event PropertyChangedEventHandler PropertyChanged;\n    public event EventHandler<DataErrorsChangedEventArgs> ErrorsChanged;\n\n    protected virtual void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n\n    protected virtual void OnErrorsChanged(string propertyName)\n    {\n        ErrorsChanged?.Invoke(this, new DataErrorsChangedEventArgs(propertyName));\n    }\n\n    public IEnumerable GetErrors(string propertyName)\n    {\n        return _errors.ContainsKey(propertyName) ? _errors[propertyName] : null;\n    }\n\n    private void ValidateProperty(string propertyName, object value)\n    {\n        List<ValidationErrorInfo> propertyValidation = new List<ValidationErrorInfo>();\n\n        if (propertyName == nameof(Name))\n        {\n            if (string.IsNullOrEmpty((string)value))\n            {\n                propertyValidation.Add(new ValidationErrorInfo\n                {\n                    ErrorText = "Name is required.",\n                    Severity = ErrorSeverity.Error,\n                    HelpLink = "https://example.com/help-001"\n                });\n            }\n        }\n\n        _errors[propertyName] = propertyValidation;\n        OnErrorsChanged(propertyName);\n    }\n\n    public class ValidationErrorInfo\n    {\n        public string ErrorText { get; set; }\n        public ErrorSeverity Severity { get; set; }\n        public string HelpLink { get; set; }\n    }\n\n    public enum ErrorSeverity\n    {\n        Info,\n        Warning,\n        Error\n    }\n}