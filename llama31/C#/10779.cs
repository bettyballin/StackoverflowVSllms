IList employeesWithAddresses = sess.CreateCriteria(typeof(Employee))\n    .CreateAlias("Address", "address", JoinType.InnerJoin)\n    .List();