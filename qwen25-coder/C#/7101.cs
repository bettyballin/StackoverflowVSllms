using System.ComponentModel;\n\npublic class YourClassName : INotifyPropertyChanged\n{\n    public event PropertyChangedEventHandler PropertyChanged;\n\n    // Example method to raise the PropertyChanged event\n    protected virtual void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n}