public class UnitOfWork : IUnitOfWork\n    {\n        private readonly DataContext _context;\n        private IRepository<Location> _locations;\n        private IRepository<Item> _items;\n\n        public UnitOfWork(DataContext context)\n        {\n            _context = context;\n        }\n\n        public IRepository<Location> Locations\n        {\n            get\n            {\n                return _locations ?? (_locations = new Repository<Location>(_context));\n            }\n        }\n\n        public IRepository<Item> Items\n        {\n            get\n            {\n                return _items ?? (_items = new Repository<Item>(_context));\n            }\n        }\n\n        public void Commit()\n        {\n            _context.SubmitChanges();\n        }\n\n        public void Dispose()\n        {\n            _context.Dispose();\n        }\n    }