// Lazy Loading\npublic class Account\n{\n    public virtual int Id { get; set; }\n    public virtual IList<User> Users { get; set; } = new List<User>();\n    public virtual Settings Settings { get; set; }\n    public virtual IList<Project> Projects { get; set; } = new List<Project>();\n}\n\n// Eager Loading with Fetch\nvar accountWithProjects = session.Query<Account>()\n    .Fetch(a => a.Projects)\n    .Where(a => a.Id == accountId)\n    .SingleOrDefault();\n\n// Using DTOs for specific data\nvar accountSettings = session.Query<Account>()\n    .Where(a => a.Id == accountId)\n    .Select(a => new AccountSettingsDTO\n    {\n        AccountId = a.Id,\n        Settings = a.Settings\n    })\n    .SingleOrDefault();