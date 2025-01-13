public class EntityMap : ClassMap<Entity>\n{\n    public EntityMap()\n    {\n        Table("Entities");\n        Id(x => x.Id).GeneratedBy.Native();\n        Map(x => x.Count).CustomType<UInt32UserType>();\n    }\n}