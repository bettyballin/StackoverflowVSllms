using System;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class ComObjectWrapper\n{\n    private readonly object _comObject;\n    private readonly Thread _comThread;\n    private readonly SynchronizationContext _syncContext;\n\n    public ComObjectWrapper(object comObject)\n    {\n        _comObject = comObject;\n        _comThread = new Thread(() =>\n        {\n            // Initialize the COM object on this thread\n            _comObject.Initialize();\n            // Set the synchronization context for this thread\n            _syncContext = SynchronizationContext.Current;\n            // Run the message loop on this thread\n            while (true)\n            {\n                Thread.Sleep(100);\n            }\n        });\n        _comThread.Start();\n    }\n\n    public void UseComObject(Action<object> action)\n    {\n        // Marshal the action to the COM thread using the synchronization context\n        _syncContext.Send(state => action(_comObject), null);\n    }\n}