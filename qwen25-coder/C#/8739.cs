public class MasterPageRepository : IMasterPageRepository\n   {\n       private readonly YourDbContext _dbContext;\n\n       public MasterPageRepository(YourDbContext dbContext)\n       {\n           _dbContext = dbContext;\n       }\n\n       public object GetMasterPageData()\n       {\n           // Fetch data from database and return it.\n           return new { /* Data */ };\n       }\n   }