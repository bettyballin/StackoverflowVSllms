private SynchronizationContext _syncContext;\n\npublic MyForm()\n{\n    _syncContext = SynchronizationContext.Current;\n}\n\nprivate void UpdateTextBox(String value)\n{\n    _syncContext.Post(state => txtPrice.Text = value, null);\n}