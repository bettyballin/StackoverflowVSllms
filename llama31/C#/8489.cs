using System.Collections.Concurrent;\n\npublic class SharedData\n{\n    private readonly ConcurrentDictionary<string, object> _data = new ConcurrentDictionary<string, object>();\n\n    public void SetData(string key, object value)\n    {\n        _data[key] = value;\n    }\n\n    public object GetData(string key)\n    {\n        return _data[key];\n    }\n}