using System;\nusing System.Collections.Generic;\nusing System.ServiceModel;\n\nnamespace WCFCallbackDemo\n{\n    public class MyService : IMyService\n    {\n        private static List<IMyCallback> clients = new List<IMyCallback>();\n\n        public void RegisterClient()\n        {\n            IMyCallback callback = OperationContext.Current.GetCallbackChannel<IMyCallback>();\n            if (!clients.Contains(callback))\n            {\n                clients.Add(callback);\n            }\n\n            // Notify the client immediately for demonstration purposes\n            callback.NotifyClient("Client registered successfully!");\n        }\n\n        public static void NotifyClients(string message)\n        {\n            foreach (var client in clients)\n            {\n                client.NotifyClient(message);\n            }\n        }\n    }\n}