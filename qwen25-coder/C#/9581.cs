using System;\nusing System.ComponentModel.Composition;\n\nnamespace MefExample\n{\n    // Part interface\n    public interface IOperation\n    {\n        string Symbol { get; }\n        double Operation(double leftOperand, double rightOperand);\n    }\n\n    [Export(typeof(IOperation))]\n    public class Add : IOperation\n    {\n        public string Symbol => "+";\n        public double Operation(double leftOperand, double rightOperand) => leftOperand + rightOperand;\n    }\n\n    public class Program\n    {\n        [ImportMany]\n        private IEnumerable<IOperation> Operations { get; set; }\n\n        static void Main(string[] args)\n        {\n            var container = new CompositionContainer(\n                new DirectoryCatalog(AppDomain.CurrentDomain.BaseDirectory));\n\n            var program = new Program();\n            container.ComposeParts(program);\n\n            foreach (var op in program.Operations)\n            {\n                Console.WriteLine($"Operation: {op.Symbol}");\n            }\n        }\n    }\n}