ServiceHost host = new ServiceHost(typeof(MyService));\nhost.Description.Behaviors.Find<ServiceBehaviorAttribute>().MaxConnections = 200;