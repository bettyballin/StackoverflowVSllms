if (typeof(T) == typeof(User))\n{\n    return db.GetView<UserActive>().AsQueryable<UserActive>();\n}\nelse\n{\n    return db.GetTable<T>().AsQueryable<T>();\n}