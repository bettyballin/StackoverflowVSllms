[ServiceBehavior(InstanceContextMode = InstanceContextMode.PerSession, ConcurrencyMode = ConcurrencyMode.Single)]\npublic class YourService : IYourService\n{\n    // Your service implementation here\n}