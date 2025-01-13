using System;\n\npublic class LetterTemplateBase : System.Web.UI.Page\n{\n    public string ForeName { get; set; } = "John";\n    public string SureName { get; set; } = "Doe";\n    public string AddressLine1 { get; set; } = "123 Main St";\n    public string AddressLine2 { get; set; } = "Suite 100";\n    public string City { get; set; } = "Anytown";\n    public string State { get; set; } = "TX";\n    public string ZipCode { get; set; } = "12345";\n\n    protected string GetContent(string contentName)\n    {\n        switch (contentName)\n        {\n            case "ForeName":\n                return ForeName;\n            case "SureName":\n                return SureName;\n            case "AddressLine1":\n                return AddressLine1;\n            case "AddressLine2":\n                return AddressLine2;\n            case "City":\n                return City;\n            case "State":\n                return State;\n            case "ZipCode":\n                return ZipCode;\n            default:\n                return string.Empty;\n        }\n    }\n}