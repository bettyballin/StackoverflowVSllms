public class SampleViewModel : ValidatableBindableBase\n{\n    private string _email;\n    public string Email\n    {\n        get => _email;\n        set\n        {\n            SetProperty(ref _email, value);\n            ValidateEmail();\n        }\n    }\n\n    private void ValidateEmail()\n    {\n        var errors = new List<string>();\n        if (string.IsNullOrWhiteSpace(Email))\n        {\n            errors.Add("Email is required.");\n        }\n        else if (!Regex.IsMatch(Email, @"^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"))\n        {\n            errors.Add("Invalid email address format.");\n       }\n\n        SetErrors(nameof(Email), errors);\n    }\n\n    public DelegateCommand SaveCommand { get; private set; }\n    \n    public SampleViewModel()\n    {\n        SaveCommand = new DelegateCommand(Save, CanSave);\n        this.PropertyChanged += (s, e) => SaveCommand.RaiseCanExecuteChanged();\n    }\n\n    private void Save()\n    {\n        if (!HasErrors)\n        {\n            // Perform save logic here\n        }\n    }\n\n    private bool CanSave() => !HasErrors;\n}