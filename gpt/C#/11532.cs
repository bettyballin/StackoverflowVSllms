using System;\nusing System.ComponentModel;\n\npublic class MyClass : INotifyPropertyChanged\n{\n    public event PropertyChangedEventHandler PropertyChanged;\n    \n    event PropertyChangedEventHandler INotifyPropertyChanged.PropertyChanged\n    {\n        add { PropertyChanged += value; }\n        remove { PropertyChanged -= value; }\n    }\n\n    protected virtual void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n}