using System;\nusing Microsoft.Web.Administration;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string appPoolName = "YourAppPoolName";\n\n        // Stop the application pool\n        StopApplicationPool(appPoolName);\n\n        // Start the application pool\n        StartApplicationPool(appPoolName);\n    }\n\n    static void StopApplicationPool(string appPoolName)\n    {\n        using (ServerManager serverManager = new ServerManager())\n        {\n            ApplicationPool appPool = serverManager.ApplicationPools[appPoolName];\n            if (appPool != null && appPool.State == ObjectState.Started)\n            {\n                appPool.Stop();\n                serverManager.CommitChanges();\n                while (appPool.State != ObjectState.Stopped)\n                {\n                    Console.WriteLine("Waiting for the application pool to stop...");\n                    System.Threading.Thread.Sleep(1000);\n                }\n                Console.WriteLine("Application Pool stopped.");\n            }\n        }\n    }\n\n    static void StartApplicationPool(string appPoolName)\n    {\n        using (ServerManager serverManager = new ServerManager())\n        {\n            ApplicationPool appPool = serverManager.ApplicationPools[appPoolName];\n            if (appPool != null && appPool.State == ObjectState.Stopped)\n            {\n                appPool.Start();\n                serverManager.CommitChanges();\n                while (appPool.State != ObjectState.Started)\n                {\n                    Console.WriteLine("Waiting for the application pool to start...");\n                    System.Threading.Thread.Sleep(1000);\n                }\n                Console.WriteLine("Application Pool started.");\n            }\n        }\n    }\n}