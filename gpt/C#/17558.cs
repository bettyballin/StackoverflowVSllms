public class MyComponent\n    {\n        [Import]\n        private IDependency1 Dependency1 { get; set; }\n\n        [Import]\n        private IDependency2 Dependency2 { get; set; }\n\n        [Import]\n        private IDependency3 Dependency3 { get; set; }\n\n        public void DoWork()\n        {\n            // Implementation that uses Dependency1, Dependency2, and Dependency3\n        }\n    }