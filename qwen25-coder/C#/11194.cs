var myInstance = new MyService();\n\ncontainer.Register(Component.For<IMyService>().Instance(myInstance));