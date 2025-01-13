class Program\n    {\n        static void Main(string[] args)\n        {\n            using(WorkflowRuntime workflowRuntime = new WorkflowRuntime())\n            {\n                AutoResetEvent waitHandle = new AutoResetEvent(false);\n                workflowRuntime.WorkflowCompleted += delegate(object sender, WorkflowCompletedEventArgs e) \n                {\n                    waitHandle.Set();\n                };\n                workflowRuntime.WorkflowTerminated += delegate(object sender, WorkflowTerminatedEventArgs e)\n                {\n                    Console.WriteLine(e.Exception.Message);\n                    waitHandle.Set();\n                };\n\n                WorkflowInstance instance = workflowRuntime.CreateWorkflow(typeof(WorkflowConsoleApplication1.Workflow1));\n                instance.Start();\n\n                waitHandle.WaitOne();\n            }\n            Console.ReadKey();\n        }\n    }