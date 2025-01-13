using SubSonic.Schema;\n\npublic class Migration001 : Migration\n{\n    public override void Up()\n    {\n        // Create a new table\n        TableSchema.Table("Users", table =>\n        {\n            table.Column("Id", DbType.Int32, true);\n            table.Column("Name", DbType.String, 50);\n            table.Column("Email", DbType.String, 100);\n        });\n    }\n\n    public override void Down()\n    {\n        // Drop the table\n        TableSchema.DropTable("Users");\n    }\n}