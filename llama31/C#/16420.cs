ObjectFactory.Initialize(x =>\n{\n    x.For<IFooRepository>().Use<FooRepository>();\n});