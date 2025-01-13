public interface IRepository<T>\n    {\n        void Add(T entity);\n        void Update(T entity);\n        void Delete(int id);\n        T GetById(int id);\n        IEnumerable<T> GetAll();\n    }