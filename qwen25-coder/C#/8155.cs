public class Version1 : Migration\n   {\n       public override void Up()\n       {\n           Create.Table("Person")\n               .WithColumn("Id").AsInt32().PrimaryKey().Identity()\n               .WithColumn("Name").AsString(50).Nullable();\n       }\n\n       public override void Down()\n       {\n           Delete.Table("Person");\n       }\n   }