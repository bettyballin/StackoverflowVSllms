public class TablePermissionAttribute : Attribute\n   {\n       public string PermissionProperty { get; }\n\n       public TablePermissionAttribute(string permissionProperty)\n       {\n           PermissionProperty = permissionProperty;\n       }\n   }