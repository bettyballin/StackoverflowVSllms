using PostSharp.Aspects;\nusing System;\n\nnamespace AOPExample\n{\n    [Serializable]\n    public class LogMethodAttribute : OnMethodBoundaryAspect\n    {\n        public override void OnEntry(MethodExecutionArgs args)\n        {\n            Console.WriteLine($"Entering {args.Method.Name}");\n        }\n\n        public override void OnExit(MethodExecutionArgs args)\n        {\n            Console.WriteLine($"Exiting {args.Method.Name}");\n        }\n    }\n\n    public class Program\n    {\n        [LogMethod]\n        public void DoSomething()\n        {\n            Console.WriteLine("Doing something...");\n        }\n\n        static void Main(string[] args)\n        {\n            Program program = new Program();\n            program.DoSomething();\n        }\n    }\n}