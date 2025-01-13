using System.ComponentModel;\n\npublic class MyViewModel : INotifyPropertyChanged, IDataErrorInfo\n{\n    private string _name;\n    public string Name\n    {\n        get { return _name; }\n        set\n        {\n            if (_name != value)\n            {\n                _name = value;\n                OnPropertyChanged(nameof(Name));\n            }\n        }\n    }\n\n    public string this[string columnName]\n    {\n        get\n        {\n            string result = null;\n            switch (columnName)\n            {\n                case nameof(Name):\n                    if (string.IsNullOrWhiteSpace(Name))\n                    {\n                        result = "Name cannot be empty.";\n                    }\n                    break;\n            }\n            return result;\n        }\n    }\n\n    public string Error => null;\n\n    public event PropertyChangedEventHandler PropertyChanged;\n\n    protected void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n}