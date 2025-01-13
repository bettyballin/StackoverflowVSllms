public abstract class BaseReferenceEntity\n{\n    public byte Id { get; set; }\n    public string Name { get; set; }\n\n    // Navigation properties (example, you might need to adjust based on your real connections)\n    public virtual ICollection<BillingReferences> ReferencingReferences { get; set; }\n}\n\n[Table("Countries")]\npublic class Country : BaseReferenceEntity\n{\n    // Additional fields specific to Country can go here\n}\n\n// Similarly define other entities\npublic class Label : BaseReferenceEntity {}\npublic class PaymentProvider : BaseReferenceEntity {}\npublic class PaymentOption : BaseReferenceEntity {}\npublic class Bank : BaseReferenceEntity {}\n\n[Table("BillingReferences")]\npublic class BillingReferences\n{\n    public byte ReferencingType { get; set; }\n    public byte ReferencingId { get; set; }\n    public byte ReferencedType { get; set; }\n    public byte ReferencedId { get; set; }\n    public bool IsActive { get; set; }\n\n    // Navigation properties to entities\n    [ForeignKey("ReferencingType, ReferencingId")]\n    public virtual BaseReferenceEntity ReferencingEntity { get; set; }\n\n    [ForeignKey("ReferencedType, ReferencedId")]\n    public virtual BaseReferenceEntity ReferencedEntity { get; set; }\n}\n\npublic class BillingDbContext : DbContext\n{\n    public DbSet<Country> Countries { get; set; }\n    public DbSet<Label> Labels { get; set; }\n    public DbSet<PaymentProvider> PaymentProviders { get; set; }\n    public DbSet<PaymentOption> PaymentOptions { get; set; }\n    public DbSet<Bank> Banks { get; set; }\n\n    protected override void OnModelCreating(DbModelBuilder modelBuilder)\n    {\n        base.OnModelCreating(modelBuilder);\n\n        modelBuilder.Entity<BaseReferenceEntity>()\n            .Map<Countries>(m => m.ToTable("Countries").HasKey(t => t.Id))\n            .Map<Label>(m => m.ToTable("Labels").HasKey(t => t.Id))\n            .Map<PaymentProvider>(m => m.ToTable("PaymentProviders").HasKey(t => t.Id))\n            .Map<PaymentOption>(m => m.ToTable("PaymentOptions").HasKey(t => t.Id))\n            .Map<Bank>(m => m.ToTable("Banks").HasKey(t => t.Id));\n\n        modelBuilder.Entity<BillingReferences>()\n            .HasIndex(b => new { b.ReferencingType, b.ReferencingId })\n            .IsUnique(true);\n\n        modelBuilder.Entity<BillingReferences>()\n            .HasIndex(b => new { b.ReferencedType, b.ReferencedId });\n    }\n}