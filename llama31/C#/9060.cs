public class ViewModel\n{\n    private Model _model;\n\n    public string Name\n    {\n        get { return _model.Name; }\n        set { _model.Name = value; }\n    }\n\n    public string Error\n    {\n        get { return _model.Error; }\n    }\n\n    public string this[string columnName]\n    {\n        get { return _model[columnName]; }\n    }\n}