protected override void OnModelCreating(ModelBuilder modelBuilder)\n{\n    modelBuilder.Entity<YourEntity>()\n        .Property(b => b.DateField)\n        .HasConversion(\n            v => v.ToString("yyyy-MM-dd HH:mm:ss"),\n            v => DateTime.Parse(v, CultureInfo.InvariantCulture));\n}