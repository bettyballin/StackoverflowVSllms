interface IObject {\n    bool IsSecureConnection { get; }\n   // ... other interface definitions //\n}\n\ninterface ISecurableObject : IObject {\n   new bool IsSecureConnection { get; set; }\n}