using System;\nusing Microsoft.TeamFoundation.Build.Client;\nusing Microsoft.TeamFoundation.Client;\nusing Microsoft.TeamFoundation.Framework.Client;\nusing Microsoft.TeamFoundation.Framework.Common;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string tfsUri = "http://your-tfs-server:8080/tfs/DefaultCollection";\n        string buildDefinitionName = "YourBuildDefinitionName";\n        \n        // Connect to TFS\n        TfsTeamProjectCollection tpc = new TfsTeamProjectCollection(new Uri(tfsUri));\n        tpc.EnsureAuthenticated();\n        \n        // Get the Build Server\n        IBuildServer buildServer = tpc.GetService<IBuildServer>();\n        \n        // Get the Build Definition\n        IBuildDefinition buildDefinition = buildServer.GetBuildDefinition("YourTeamProjectName", buildDefinitionName);\n        \n        // Create a Build Request\n        IBuildRequest buildRequest = buildDefinition.CreateBuildRequest();\n        \n        // Queue the Build\n        IQueuedBuild queuedBuild = buildServer.QueueBuild(buildRequest);\n        \n        Console.WriteLine("Build queued. Build ID: " + queuedBuild.Id);\n        \n        // Track the Build Status\n        while (queuedBuild.Status == QueueStatus.Queued || queuedBuild.Status == QueueStatus.InProgress)\n        {\n            Console.WriteLine("Build Status: " + queuedBuild.Status);\n            System.Threading.Thread.Sleep(5000); // Wait for 5 seconds\n            queuedBuild.Refresh(QueryOptions.All);\n        }\n        \n        Console.WriteLine("Build Completed. Final Status: " + queuedBuild.Status);\n    }\n}