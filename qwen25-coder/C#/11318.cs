HasManyToMany(x => x.PermissionIds)\n        .WithParentKeyColumn("RoleId")\n        .Element(column =>\n            column.Column("PermissionId").Type<NHibernate.Type.IntegralType, int>())\n        .WithTableName("RolePermissions")\n        .LazyLoad()\n        .Cascade.All();