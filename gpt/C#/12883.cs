public class GameMap : ClassMap<Game>\n{\n    public GameMap()\n    {\n        Id(x => x.Id);\n        References(x => x.Event)\n            .Fetch.Join(); // Optimize fetching strategy\n        // Other mappings...\n    }\n}\n\npublic class EventMap : ClassMap<Event>\n{\n    public EventMap()\n    {\n        Id(x => x.Id);\n        Map(x => x.EventId).Unique();\n        // Other mappings...\n    }\n}