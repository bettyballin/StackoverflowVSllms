public class MyEntityMap : ClassMap<MyEntity>\n{\n    public MyEntityMap()\n    {\n        Table("MyTable");\n        Id(x => x.Id).Column("Id").GeneratedBy.Assigned().CustomType<string>();\n        // Other property mappings\n    }\n}