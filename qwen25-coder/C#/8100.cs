using System;\nusing System.Collections.Generic;\n\npublic class HtmlElement\n{\n    private readonly string _tagName;\n    private Dictionary<string, string> _attributes = new Dictionary<string, string>();\n\n    public HtmlElement(string tagName)\n    {\n        _tagName = tagName;\n    }\n\n    public void AddAttribute(string key, string value)\n    {\n        if (_attributes.ContainsKey(key))\n            _attributes[key] = value;\n        else\n            _attributes.Add(key, value);\n    }\n\n    public string GenerateHtml()\n    {\n        var attributesString = "";\n        foreach (var attr in _attributes)\n        {\n            attributesString += $" {attr.Key}=\"{attr.Value}\"";\n        }\n        return $"<{_tagName}{attributesString}></{_tagName}>";\n    }\n}\n\npublic class HtmlCheckbox : HtmlElement\n{\n    public HtmlCheckbox(Dictionary<string, string> attributes) : base("input")\n    {\n        _attributes.Add("type", "checkbox");\n        foreach (var attr in attributes)\n        {\n            AddAttribute(attr.Key, attr.Value);\n        }\n    }\n\n    // Optionally override GenerateHtml with specific logic if needed\n}\n\n// Usage example\npublic static class HtmlGenerator\n{\n    public static string GetCheckboxHtml()\n    {\n        var checkboxAttributes = new Dictionary<string, string>\n        {\n            { "name", "somename" },\n            { "id", "someid" }\n        };\n\n        var checkbox = new HtmlCheckbox(checkboxAttributes);\n        return checkbox.GenerateHtml();\n    }\n}