var results = session.Query<MyClass>().Take(15).ToList();