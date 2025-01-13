public class ReviewMap : ClassMap<Review>\n{\n    public ReviewMap()\n    {\n        Table("Reviews");\n        Id(x => x.ReviewId).GeneratedBy.Identity();\n        References(x => x.Business, "BusinessId"); // Use simpler overload for column name\n        Map(x => x.ReviewText);\n    }\n}\n\npublic class BusinessMap : ClassMap<Business>\n{\n    public BusinessMap()\n    {\n        Table("Businesses");\n        Id(x => x.BusinessId).GeneratedBy.Identity();\n        Map(x => x.Name, "BusinessName"); // Use simpler overload for column name\n        Map(x => x.LastModified, "LastModifiedOn"); \n        HasMany<Review>(x => x.Reviews)\n            .Inverse() // This should be correct if Review owns the relationship\n            .Cascade.None() // Do not cascade saves to reviews or inversely from reviews back to business\n            .LazyLoad();\n    }\n}