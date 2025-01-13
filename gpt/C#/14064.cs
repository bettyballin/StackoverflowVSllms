public class ParentMap : ClassMap<Parent>\n{\n    public ParentMap()\n    {\n        Id(x => x.ID).GeneratedBy.Identity();\n        // other mappings\n    }\n}\n\npublic class ChildMap : ClassMap<Child>\n{\n    public ChildMap()\n    {\n        Id(x => x.ChildID).GeneratedBy.Identity();\n        References(x => x.Parent).Column("ParentID").Not.Nullable();\n        // other mappings\n    }\n}