using System;\nusing System.Threading;\n\npublic class Foo\n{\n    public event EventHandler MyEvent;\n\n    public void RaiseEvent()\n    {\n        MyEvent?.Invoke(this, EventArgs.Empty);\n    }\n}\n\npublic class Bar\n{\n    private readonly SynchronizationContext _context;\n\n    public Bar()\n    {\n        _context = SynchronizationContext.Current;\n    }\n\n    public void Start()\n    {\n        // Start a new thread for Bar\n        new Thread(() =>\n        {\n            // Create an instance of Foo\n            var foo = new Foo();\n\n            // Subscribe to the event\n            foo.MyEvent += (sender, args) =>\n            {\n                // This will be executed on the thread of Bar\n                Console.WriteLine("Received event on Bar's thread");\n            };\n\n            // Raise the event on Foo's thread\n            foo.RaiseEvent();\n        }).Start();\n    }\n}