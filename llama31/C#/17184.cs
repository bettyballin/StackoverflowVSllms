public class MyDbContext : DbContext\n{\n    public MyDbContext()\n        : base("name=MyDbContext")\n    {\n        DbInterception.Add(new RowLevelSecurityInterceptor());\n    }\n}