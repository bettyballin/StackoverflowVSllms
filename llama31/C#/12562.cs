var session = // get your NHibernate session\nvar accounts = session.Query<Account>().Where(a => a.Amount < 1000);\nforeach (var account in accounts)\n{\n    session.Delete(account);\n}\nsession.Flush();