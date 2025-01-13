using System;\nusing System.Threading;\n\npublic class MyController : Controller\n{\n    public ActionResult Index()\n    {\n        // Queue a task to the thread pool and forget about it\n        ThreadPool.QueueUserWorkItem(state => {\n            // Simulate a lengthy operation\n            Thread.Sleep(5000);\n            Console.WriteLine("Operation complete.");\n        });\n\n        // Return control to the user immediately\n        return PartialView("Loading");\n    }\n}