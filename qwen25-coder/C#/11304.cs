HasManyToMany(x => x.Permissions)\n        .WithParentKeyColumn("RoleId")\n        .Element(column => column.Column("PermissionId").Type<EnumInt32Type<Permission>>())\n        .WithTableName("RolePermissions")\n        .LazyLoad()\n        .Cascade.All();