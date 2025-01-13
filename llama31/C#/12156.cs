// Create a new work item\nWorkItem wi = new WorkItem("Task");\nwi.Title = "Implement VSTS";\nwi.Description = "Consolidate tools and processes";\nwi.Save();\n\n// Query work items\nQuery query = new Query("SELECT * FROM WorkItems WHERE [System.WorkItemType] = 'Task'");\nWorkItemCollection results = query.Run();\nforeach (WorkItem wi in results)\n{\n    Console.WriteLine(wi.Title);\n}