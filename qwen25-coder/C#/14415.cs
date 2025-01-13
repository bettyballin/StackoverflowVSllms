public class RegistrationController : Controller {\n    private ApplicationDbContext db = new ApplicationDbContext();\n\n    // GET: Register/Event/{eventId}\n    public ActionResult Event(int eventId) {\n        var @event = db.Events.Include(e => e.Questions).FirstOrDefault(e => e.EventId == eventId);\n\n        if (@event == null) return HttpNotFound();\n        \n        ViewBag.Questions = @event.Questions;\n\n        return View(new Registration());\n    }\n\n    // POST: Register/Event/{eventId}\n    [HttpPost]\n    public ActionResult Event(int eventId, FormCollection form) {\n        var registration = new Registration()\n        {\n            EventId = eventId,\n            AnswersJson = JsonConvert.SerializeObject(form.AllKeys.ToDictionary(key => key, key => form[key]))\n        };\n\n        db.Registrations.Add(registration);\n        db.SaveChanges();\n\n        return RedirectToAction("Index");\n    }\n}