public event PropertyChangedEventHandler PropertyChanged\n{\n    add { ((INotifyPropertyChanged)this).PropertyChanged += value; }\n    remove { ((INotifyPropertyChanged)this).PropertyChanged -= value; }\n}