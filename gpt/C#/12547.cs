using System.Data.Entity;\n\npublic class BirdContext : DbContext\n{\n    public DbSet<Bird> Birds { get; set; }\n    \n    public BirdContext() : base("name=YourConnectionStringName")\n    {\n    }\n}