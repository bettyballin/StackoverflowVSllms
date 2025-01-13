using System;\nusing System.Collections.Generic;\n\n// Sample interface for objects raising events\npublic interface IEventSource\n{\n    event EventHandler SolutionExpired;\n    event EventHandler DisplayExpired;\n}\n\n// Document class that manages subscriptions\npublic class Document\n{\n    private List<Delegate> _handlers = new List<Delegate>();\n\n    public void AddObject(IEventSource obj)\n    {\n        var defObjSolutionExpiredHandler = new EventHandler(DefObj_SolutionExpired);\n        var displayExpiredHandler = new EventHandler(DisplayExpiredMethod);\n\n        // Subscribe to events and keep track of the handlers\n        obj.SolutionExpired += defObjSolutionExpiredHandler;\n        _handlers.Add(defObjSolutionExpiredHandler);\n\n        obj.DisplayExpired += displayExpiredHandler;\n        _handlers.Add(displayExpiredHandler);\n    }\n\n    public void RemoveAllHandlers()\n    {\n        foreach (var handler in _handlers)\n        {\n            foreach (IEventSource eventSource in GetEventSources()) // Assume this method returns all IEventSource objects\n            {\n                FieldInfo info = typeof(IEventSource).GetField("SolutionExpired", BindingFlags.Instance | BindingFlags.Public | BindingFlags.NonPublic);\n                if (info != null && handler is EventHandler)\n                    ((EventHandler)info.GetValue(eventSource)).GetInvocationList().ToList().ForEach(h => eventSource.SolutionExpired -= h as EventHandler);\n\n                info = typeof(IEventSource).GetField("DisplayExpired", BindingFlags.Instance | BindingFlags.Public | BindingFlags.NonPublic);\n                if (info != null && handler is EventHandler)\n                    ((EventHandler)info.GetValue(eventSource)).GetInvocationList().ToList().ForEach(h => eventSource.DisplayExpired -= h as EventHandler);\n            }\n        }\n\n        _handlers.Clear();\n    }\n\n    private IEnumerable<IEventSource> GetEventSources()\n    {\n        // Implementation to get all IEventSource objects in the document\n        throw new NotImplementedException();\n    }\n\n    private void DefObj_SolutionExpired(object sender, EventArgs e)\n    {\n        // Handle SolutionExpired event\n    }\n\n    private void DisplayExpiredMethod(object sender, EventArgs e)\n    {\n        // Handle DisplayExpired event\n    }\n}