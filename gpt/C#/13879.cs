ICriteria criteria = session.CreateCriteria(typeof(SomeEntity))\n                            .Add(Restrictions.In("propertyName", new object[] { value1, value2, value3 }));