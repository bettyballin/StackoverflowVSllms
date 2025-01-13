using System;\nusing System.ComponentModel;\nusing System.Security.Principal;\nusing System.Threading;\n\npublic class AuditableModel : INotifyPropertyChanging, INotifyPropertyChanged\n{\n    public event PropertyChangingEventHandler PropertyChanging;\n    public event PropertyChangedEventHandler PropertyChanged;\n\n    private DateTime _createdAt;\n    private DateTime _updatedAt;\n    private string _createdBy;\n    private string _updatedBy;\n\n    public DateTime CreatedAt\n    {\n        get { return _createdAt; }\n        set\n        {\n            OnPropertyChanging(nameof(CreatedAt));\n            _createdAt = value;\n            OnPropertyChanged(nameof(CreatedAt));\n        }\n    }\n\n    public DateTime UpdatedAt\n    {\n        get { return _updatedAt; }\n        set\n        {\n            OnPropertyChanging(nameof(UpdatedAt));\n            _updatedAt = value;\n            OnPropertyChanged(nameof(UpdatedAt));\n        }\n    }\n\n    public string CreatedBy\n    {\n        get { return _createdBy; }\n        set\n        {\n            OnPropertyChanging(nameof(CreatedBy));\n            _createdBy = value;\n            OnPropertyChanged(nameof(CreatedBy));\n        }\n    }\n\n    public string UpdatedBy\n    {\n        get { return _updatedBy; }\n        set\n        {\n            OnPropertyChanging(nameof(UpdatedBy));\n            _updatedBy = value;\n            OnPropertyChanged(nameof(UpdatedBy));\n        }\n    }\n\n    private void OnPropertyChanging(string propertyName)\n    {\n        PropertyChanging?.Invoke(this, new PropertyChangingEventArgs(propertyName));\n    }\n\n    private void OnPropertyChanged(string propertyName)\n    {\n        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));\n    }\n\n    public void UpdateAuditFields()\n    {\n        var currentUser = Thread.CurrentPrincipal.Identity.Name;\n        if (string.IsNullOrEmpty(CreatedBy))\n        {\n            CreatedBy = currentUser;\n            CreatedAt = DateTime.UtcNow;\n        }\n        UpdatedBy = currentUser;\n        UpdatedAt = DateTime.UtcNow;\n    }\n}