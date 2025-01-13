public enum PermissionLevel\n{\n    Disabled,\n    ReadOnly,\n    Edit\n}\n\npublic class User\n{\n    public bool IsAuthorized(PermissionLevel permission)\n    {\n        // Check user permissions against the database or a cache\n        // Return true if the user has the required permission, false otherwise\n    }\n}\n\npublic class FormControl\n{\n    [Permission(PermissionLevel.Edit)]\n    public Button SaveButton { get; set; }\n\n    public FormControl(User user)\n    {\n        if (!user.IsAuthorized(PermissionLevel.Edit))\n        {\n            SaveButton.Enabled = false;\n        }\n    }\n}