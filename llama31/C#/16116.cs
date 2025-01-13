public class LoginController : Controller\n{\n    [HttpPost]\n    public ActionResult Login(string username, string password, bool rememberMe)\n    {\n        // Validate the user credentials\n        if (ModelState.IsValid)\n        {\n            // Log the user in\n            FormsAuthentication.SetAuthCookie(username, rememberMe);\n            return Json(new { success = true });\n        }\n        else\n        {\n            return Json(new { success = false, message = "Invalid username or password" });\n        }\n    }\n}