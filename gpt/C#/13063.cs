using NHibernate;\nusing System.Collections.Generic;\n\npublic IList<T> GetPagedResults<T>(ISession session, int pageNumber, int pageSize)\n{\n    // Calculate the starting index of the records for the given page\n    int firstResult = (pageNumber - 1) * pageSize;\n\n    // Create the query\n    IQuery query = session.CreateQuery("from YourEntityName");\n\n    // Set paging parameters\n    query.SetFirstResult(firstResult);\n    query.SetMaxResults(pageSize);\n\n    // Execute the query and return the results\n    return query.List<T>();\n}