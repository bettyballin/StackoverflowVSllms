using System;\nusing Microsoft.SharePoint.Client;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        const string siteUrl = "https://your-sharepoint-site";\n        const string listTitle = "Your List Title";\n        const int itemId = 1; // ID of the list item with the workflow you want to stop\n\n        using (ClientContext clientContext = new ClientContext(siteUrl))\n        {\n            // Authentication for SharePoint Online\n            clientContext.Credentials = new SharePointOnlineCredentials("your-email@domain.com", GetSecureStringPassword("your-password"));\n\n            List targetList = clientContext.Web.Lists.GetByTitle(listTitle);\n            ListItem item = targetList.GetItemById(itemId);\n\n            WorkflowServicesManager workflowServicesManager = new WorkflowServicesManager(clientContext, clientContext.Web);\n            IWorkflowInstanceService workflowInstanceService = workflowServicesManager.GetWorkflowInstanceService();\n\n            // Fetch workflows related to the list item\n            IEnumerable<Guid> workflowInstanceIds = workflowInstanceService.EnumerateInstancesForListItem(targetList.Id, itemId);\n\n            foreach (Guid instanceId in workflowInstanceIds)\n            {\n                WorkflowInstance workflowInstance = workflowInstanceService.GetInstance(instanceId);\n                \n                clientContext.Load(workflowInstance);\n                clientContext.ExecuteQuery();\n\n                if (workflowInstance.Status == WorkflowStatus.Running)\n                {\n                    workflowInstanceService.TerminateWorkflow(workflowInstance.InstanceId, "Cancelled via script due to database change");\n                    Console.WriteLine($"Terminated workflow {workflowInstance.InstanceId}.");\n                }\n            }\n\n            clientContext.ExecuteQuery();\n        }\n    }\n\n    private static SecureString GetSecureStringPassword(string password)\n    {\n        var secureString = new SecureString();\n\n        foreach (char c in password) secureString.AppendChar(c);\n\n        return secureString;\n    }\n}