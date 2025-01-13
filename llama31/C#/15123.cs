public class Foo\n{\n    public int FooId { get; set; }\n    public string FooCode { get; set; }\n    public virtual ICollection<Bar> Bars { get; set; }\n}\n\npublic class Bar\n{\n    public int BarId { get; set; }\n    public string BarFooCode { get; set; }\n    public virtual Foo Foo { get; set; }\n}\n\npublic class FooConfiguration : EntityTypeConfiguration<Foo>\n{\n    public FooConfiguration()\n    {\n        HasKey(f => f.FooId);\n        Property(f => f.FooCode).IsRequired();\n    }\n}\n\npublic class BarConfiguration : EntityTypeConfiguration<Bar>\n{\n    public BarConfiguration()\n    {\n        HasKey(b => b.BarId);\n        Property(b => b.BarFooCode).IsRequired();\n        HasRequired(b => b.Foo)\n            .WithMany(f => f.Bars)\n            .HasForeignKey(b => b.BarFooCode);\n    }\n}