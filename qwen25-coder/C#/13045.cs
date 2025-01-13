using System;\nusing Microsoft.Diagnostics.Tracing.Session;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        using (var session = new TraceEventSession("MyRegistryMonitoring"))\n        {\n            session.EnableProvider(Microsoft.Windows.Registry);\n            session.Source.Process();\n\n            Console.WriteLine("Listening for registry operations. Press Enter to stop.");\n            Console.ReadLine();\n        }\n    }\n\n    [EventSourceAttribute(Name = "Microsoft-Windows-Registry")]\n    public sealed class RegistryProvider : EventSource\n    {\n        static public RegistryProvider Log = new RegistryProvider();\n\n        public void OperationStart() { if (IsEnabled()) WriteEvent(1); }\n        public void OperationEnd()   { if (IsEnabled()) WriteEvent(2); }\n    }\n}