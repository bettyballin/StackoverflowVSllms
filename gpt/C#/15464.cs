using System;\nusing System.Linq;\nusing System.Data.Entity;\n\npublic class Collect\n{\n    public int CollectId { get; set; }\n    public string Url { get; set; }\n    public string UserId { get; set; }\n    public DateTime PubTime { get; set; }\n}\n\npublic class CollectContext : DbContext\n{\n    public DbSet<Collect> Collects { get; set; }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        using (var context = new CollectContext())\n        {\n            var result = context.Collects\n                .GroupBy(c => new { c.Url, c.CollectId, c.UserId, c.PubTime })\n                .Where(g => g.Key.PubTime >= context.Collects\n                    .Where(d => d.Url == g.Key.Url)\n                    .Max(d => d.PubTime))\n                .OrderByDescending(g => g.Key.PubTime)\n                .Select(g => new\n                {\n                    g.Key.CollectId,\n                    g.Key.Url,\n                    g.Key.UserId,\n                    g.Key.PubTime\n                })\n                .ToList();\n\n            foreach (var item in result)\n            {\n                Console.WriteLine($"{item.CollectId}, {item.Url}, {item.UserId}, {item.PubTime}");\n            }\n        }\n    }\n}