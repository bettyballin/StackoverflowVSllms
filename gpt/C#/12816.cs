public class PermissionMap : ClassMap<Permission>\n   {\n       public PermissionMap()\n       {\n           Table("Permissions");\n           Id(x => x.PermissionId).GeneratedBy.Assigned();\n           Map(x => x.PermissionName).Not.Nullable();\n       }\n   }