var cfg = new NHibernate.Cfg.Configuration();\nvar hql = "from customers c where c.country = :country";\nvar sql = cfg.GenerateSql(hql, new Dictionary<string, object> { { "country", customerConfig.Country } });