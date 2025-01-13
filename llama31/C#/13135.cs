public class WebAgentPermission\n{\n    private Dictionary<string, bool> permissions;\n\n    public WebAgentPermission()\n    {\n        permissions = new Dictionary<string, bool>();\n    }\n\n    public void SetPermission(string name, bool value)\n    {\n        permissions[name] = value;\n    }\n\n    public bool GetPermission(string name)\n    {\n        return permissions.TryGetValue(name, out bool value) ? value : false;\n    }\n}