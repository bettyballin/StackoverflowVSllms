[ServiceContract]\n   public interface ITaskService\n   {\n       [OperationContract]\n       [WebInvoke(Method = "POST", UriTemplate = "tasks", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Bare)]\n       void AddTask(Task task);\n   }