using Castle.MicroKernel.Registration;\nusing Castle.Windsor;\nusing Castle.Windsor.Installer;\nusing NUnit.Framework;\n\n[TestFixture]\npublic class WindsorContainerTests\n{\n    private IWindsorContainer _container;\n\n    [SetUp]\n    public void SetUp()\n    {\n        _container = new WindsorContainer();\n        _container.Install(FromAssembly.This());\n    }\n\n    [Test]\n    public void AllComponents_ShouldBeResolvable()\n    {\n        var handlers = _container.Kernel.GetAssignableHandlers(typeof(object));\n        foreach (var handler in handlers)\n        {\n            var component = _container.Resolve(handler.ComponentModel.Name);\n            Assert.IsNotNull(component, $"Component '{handler.ComponentModel.Name}' could not be resolved.");\n            _container.Release(component);\n        }\n    }\n\n    [TearDown]\n    public void TearDown()\n    {\n        _container.Dispose();\n    }\n}