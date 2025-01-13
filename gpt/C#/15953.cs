[Flags]\npublic enum WebAgentPermissionPart1 : long\n{\n    ViewRuleGroup = 1,\n    AddRuleGroup = 2,\n    EditRuleGroup = 4,\n    DeleteRuleGroup = 8,\n    ViewRule = 16,\n    AddRule = 32,\n    EditRule = 64,\n    DeleteRule = 128,\n    ViewLocation = 256,\n    AddLocation = 512,\n    EditLocation = 1024,\n    DeleteLocation = 2048,\n    ViewVolumeStatistics = 4096,\n    EditVolumeStatistics = 8192,\n    UploadVolumeStatistics = 16384,\n    // Add more as needed\n}\n\n[Flags]\npublic enum WebAgentPermissionPart2 : long\n{\n    // Continue with the next permissions\n    AnotherPermission1 = 1,\n    AnotherPermission2 = 2,\n    // And so on...\n}\n\npublic class WebAgentPermissions\n{\n    public WebAgentPermissionPart1 Part1 { get; set; }\n    public WebAgentPermissionPart2 Part2 { get; set; }\n\n    // Add more parts as needed\n\n    public bool HasPermission(WebAgentPermissionPart1 permission)\n    {\n        return (Part1 & permission) == permission;\n    }\n\n    public bool HasPermission(WebAgentPermissionPart2 permission)\n    {\n        return (Part2 & permission) == permission;\n    }\n\n    public void AddPermission(WebAgentPermissionPart1 permission)\n    {\n        Part1 |= permission;\n    }\n\n    public void AddPermission(WebAgentPermissionPart2 permission)\n    {\n        Part2 |= permission;\n    }\n\n    public void RemovePermission(WebAgentPermissionPart1 permission)\n    {\n        Part1 &= ~permission;\n    }\n\n    public void RemovePermission(WebAgentPermissionPart2 permission)\n    {\n        Part2 &= ~permission;\n    }\n}