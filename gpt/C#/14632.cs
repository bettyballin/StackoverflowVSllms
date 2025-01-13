public class CityMap : ClassMap<City>\n{\n    public CityMap()\n    {\n        Table("CITY");\n        Id(x => x.Id).GeneratedBy.Identity();\n        Map(x => x.Name);\n    }\n}\n\npublic class FooBarMap : ClassMap<FooBar>\n{\n    public FooBarMap()\n    {\n        Table("FOOBAR");\n        Id(x => x.Id).GeneratedBy.Identity();\n        Map(x => x.Value);\n    }\n}