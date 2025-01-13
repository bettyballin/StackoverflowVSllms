public class SpaceLocationMap : ClassMap<SpaceLocation>\n{\n    public SpaceLocationMap()\n    {\n        Id(x => x.Id);  // Assuming you have an Id property for SpaceLocation\n\n        Component(x => x.Coordinates, m => \n        {\n            m.Map(x => x.x).Column("x").Not.Nullable().UniqueKey("UK_Coordinates");\n            m.Map(x => x.y).Column("y").Not.Nullable().UniqueKey("UK_Coordinates");\n            m.Map(x => x.z).Column("z").Not.Nullable().UniqueKey("UK_Coordinates");\n        });\n\n        References(x => x.AtLocation).Column("AtLocationId");  // Assuming you have a reference to SpaceObject\n    }\n}