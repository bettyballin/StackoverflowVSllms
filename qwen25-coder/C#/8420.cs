public class JobController : Controller\n{\n    // Start the long running job, perhaps return a unique job id\n    public ActionResult StartJob()\n    {\n        // Simulate starting a background task.\n        BackgroundJob.Start(() => LongRunningProcess());\n        return Json(new { jobId = 1 }, JsonRequestBehavior.AllowGet);\n    }\n\n    private static void LongRunningProcess()\n    {\n        System.Threading.Thread.Sleep(5000); // Simulate job processing\n        HttpContext.Current.Application["jobStatus"] = "done";\n    }\n\n    // Get current status of the job\n    public ActionResult CheckJobStatus(int jobId)\n    {\n        var status = HttpContext.Current.Application["jobStatus"];\n        return Json(new { Status = status ?? "working" }, JsonRequestBehavior.AllowGet);\n    }\n}