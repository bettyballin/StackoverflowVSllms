Private Shared Function SessionFactory() As ISessionFactory\n    If _sessionFactory Is Nothing Then\n        Dim config As New NHibernate.Cfg.Configuration\n        config.Configure()\n        config.AddAssembly("YourAssemblyName")\n        _sessionFactory = config.BuildSessionFactory()\n    End If\n    Return _sessionFactory\nEnd Functio