[OperationContract]\n   [WebInvoke(Method = "POST", UriTemplate = "tasks", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json)]\n   Task AddTask(Task task);