using System;\nusing System.Collections.Generic;\nusing System.Windows.Forms;\n\npublic interface ISettingsControl {\n    bool Validate();\n    string ValidationMessage { get; }\n    void LoadSetting(string value);\n    string SaveSetting();\n}\n\npublic delegate bool InputIsOkHandler();\n\npublic class TextBoxSetting : ISettingsControl {\n    private readonly TextBox _control;\n    private readonly InputIsOkHandler _inputHandler;\n    private readonly string _errorMessage;\n\n    public TextBoxSetting(TextBox control, InputIsOkHandler inputHandler, string errorMessage) {\n        _control = control;\n        _inputHandler = inputHandler;\n        _errorMessage = errorMessage;\n    }\n\n    public bool Validate() {\n        return _inputHandler();\n    }\n\n    public string ValidationMessage => _errorMessage;\n\n    public void LoadSetting(string value) {\n        _control.Text = value;\n    }\n\n    public string SaveSetting() {\n        return _control.Text;\n    }\n}\n\npublic class SettingsManager {\n    private readonly List<ISettingsControl> _settingsControls = new List<ISettingsControl>();\n\n    public void Add(ISettingsControl control) {\n        _settingsControls.Add(control);\n    }\n\n    public bool ValidateAll(out string errorMessage) {\n        foreach (var control in _settingsControls) {\n            if (!control.Validate()) {\n                errorMessage = control.ValidationMessage;\n                return false;\n            }\n        }\n        errorMessage = null;\n        return true;\n    }\n\n    public void SaveSettings(string settingsFilePath) {\n        var settingsData = new Dictionary<string, string>();\n        foreach (var control in _settingsControls) {\n            settingsData[control.GetType().FullName] = control.SaveSetting();\n        }\n        SettingsIO.Save(settingsFilePath, settingsData);\n    }\n\n    public void LoadSettings(string settingsFilePath) {\n        var settingsData = SettingsIO.Load(settingsFilePath);\n        foreach (var kvp in settingsData) {\n            var control = _settingsControls.Find(c => c.GetType().FullName == kvp.Key);\n            if (control != null) {\n                control.LoadSetting(kvp.Value);\n            }\n        }\n    }\n\n    public static class SettingsIO {\n        public static void Save(string filePath, Dictionary<string, string> data) {\n            // Implement saving logic here\n        }\n\n        public static Dictionary<string, string> Load(string filePath) {\n            // Implement loading logic here\n            return new Dictionary<string, string>();\n        }\n    }\n}