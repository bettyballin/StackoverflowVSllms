public class ViewEntityMap : ClassMap<ViewEntity>\n{\n    public ViewEntityMap()\n    {\n        Table("VIEW");\n        Id(x => x.Id);\n        Map(x => x.Position);\n        References(x => x.SourceView).Column("SourceView").Nullable();\n    }\n}