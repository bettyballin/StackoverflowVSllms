using System;\nusing Castle.DynamicProxy;\n\npublic class Program\n{\n    public interface IMyInterface\n    {\n        void DoSomething();\n    }\n\n    public class MyClass : IMyInterface\n    {\n        public void DoSomething()\n        {\n            Console.WriteLine("Doing something...");\n        }\n    }\n\n    public static void Main(string[] args)\n    {\n        var generator = new ProxyGenerator();\n        var myClassInstance = new MyClass();\n\n        // Create a proxy for MyClass implementing IMyInterface\n        var proxy = generator.CreateInterfaceProxyWithTarget<IMyInterface>(myClassInstance,\n            ProxyGenerationOptions.Default, \n            new MyInterceptor());\n\n        proxy.DoSomething();\n    }\n}\n\npublic class MyInterceptor : StandardInterceptor\n{\n    protected override void PreProceed(IInvocation invocation)\n    {\n        Console.WriteLine("Before method execution");\n    }\n\n    protected override void PostProceed(IInvocation invocation)\n    {\n        Console.WriteLine("After method execution");\n    }\n}