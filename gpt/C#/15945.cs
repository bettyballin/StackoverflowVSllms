using System.ComponentModel;\nusing System.Windows;\n\npublic class YourViewModel : INotifyPropertyChanged\n{\n    private bool _isFormValid = true;\n    public bool IsFormValid\n    {\n        get => _isFormValid;\n        set\n        {\n            if (_isFormValid != value)\n            {\n                _isFormValid = value;\n                OnPropertyChanged("IsFormValid");\n            }\n        }\n    }\n\n    public event PropertyChangedEventHandler PropertyChanged;\n    protected void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n}