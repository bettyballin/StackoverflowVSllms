public class BenchmarkController : Controller\n{\n    public ActionResult Test()\n    {\n        var watch = System.Diagnostics.Stopwatch.StartNew();\n        \n        // Simulate some processing logic here\n        for (int i = 0; i < 1000; i++)\n        {\n            Math.Sqrt(i);\n        }\n        \n        watch.Stop();\n        ViewBag.ExecutionTime = watch.ElapsedMilliseconds;\n        return View();\n    }\n}