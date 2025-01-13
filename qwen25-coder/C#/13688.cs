using Microsoft.Azure.Storage.Queue;\nusing System.Threading.Tasks;\n\npublic class BuildQueueService\n{\n    private CloudQueue _buildQueue;\n\n    public BuildQueueService(string connectionString)\n    {\n        var storageAccount = CloudStorageAccount.Parse(connectionString);\n        var queueClient = storageAccount.CreateCloudQueueClient();\n        _buildQueue = queueClient.GetQueueReference("buildqueue");\n        _buildQueue.CreateIfNotExistsAsync().Wait(); // Ensure the queue exists\n    }\n\n    public async Task EnqueueBuildMessage()\n    {\n        var message = new CloudQueueMessage("trigger build");\n        await _buildQueue.AddMessageAsync(message);\n    }\n}\n\nprotected void _Build_Click(object sender, EventArgs e)\n{\n    if (Build.IsBuilding) return;\n\n    var service = new BuildQueueService(ConfigurationManager.ConnectionStrings["AzureWebJobsStorage"].ConnectionString);\n    service.EnqueueBuildMessage().Wait();\n}