Guid[] ids = new Guid[]; // example ids array\n\nif (ids.Length == 0)\n{\n    return new List<User>(); // or whatever the appropriate type is\n}\n\nvar query = NHibernateSession.CreateQuery("from User u where u.id in (:ids)");\nquery.SetParameterList("ids", ids);\nreturn query.ToList();