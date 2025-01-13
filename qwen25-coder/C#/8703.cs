public class YourDbContext : DbContext\n{\n    public override int SaveChanges()\n    {\n        var entries = ChangeTracker.Entries().Where(e => e.Entity is IHasLastModifiedDate && (e.State == EntityState.Added || e.State == EntityState.Modified));\n\n        foreach (var entry in entries)\n        {\n            ((IHasLastModifiedDate)entry.Entity).LastModifiedDate = DateTime.Now;\n        }\n\n        return base.SaveChanges();\n    }\n}\n\npublic interface IHasLastModifiedDate\n{\n    DateTime LastModifiedDate { get; set; }\n}