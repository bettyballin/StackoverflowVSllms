public interface IStorage\n{\n    string FilePath { get; set; }\n}\n\npublic class Storage : IStorage\n{\n    public string FilePath { get; set; }\n}\n\n// Register the storage instance in your container\nvar builder = new ContainerBuilder();\nbuilder.RegisterType<Storage>().As<IStorage>().SingleInstance();\nvar container = builder.Build();\n\n// Resolve the storage instance in your classes\nvar storage = container.Resolve<IStorage>();