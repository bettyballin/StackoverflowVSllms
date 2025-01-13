public class TransactionMap : ClassMap<Transaction>\n{\n    public TransactionMap()\n    {\n        Id(x => x.Id).GeneratedBy.Identity();\n        HasManyToOne(x => x.TransactionDetail)\n            .ForeignKey("Id")\n            .Not.Update() // This ensures that the foreign key on the Transaction side is never updated.\n            .Cascade.None(); // Avoid cascading updates to related entities\n    }\n}\n\npublic class TransactionDetailMap : ClassMap<TransactionDetail>\n{\n    public TransactionDetailMap()\n    {\n        Id(x => x.Id).GeneratedBy.Foreign("Transaction"); // Assuming the primary key of TransactionDetail references Transaction\n        References(x => x.Transaction)\n            .Column("Id")\n            .Constrained(); // Ensures that a row exists in the Transaction table before associating in TransactionDetail\n    }\n}