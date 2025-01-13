using System.ComponentModel;\nusing System.Windows;\n\npublic partial class MainWindow : Window, INotifyPropertyChanged\n{\n    private Visibility _actionsVisible;\n\n    public Visibility ActionsVisible\n    {\n        get { return _actionsVisible; }\n        set\n        {\n            if (_actionsVisible != value)\n            {\n                _actionsVisible = value;\n                OnPropertyChanged("ActionsVisible");\n            }\n        }\n    }\n\n    public MainWindow()\n    {\n        InitializeComponent();\n        this.DataContext = this;\n    }\n\n    public event PropertyChangedEventHandler PropertyChanged;\n\n    protected virtual void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n}