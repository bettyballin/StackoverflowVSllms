using System.ComponentModel.DataAnnotations.Schema;\n\n[Table("Articles")]\npublic class Article : Content\n{\n    [Key]\n    public override int ID { get; set; }\n    // Additional properties specific to an article can be added here\n}\n\n[Table("NewsItems")]\npublic class NewsItem : Content\n{\n    [Key]\n    public override int ID { get; set; }\n    // Additional properties specific to a news item can be added here\n}