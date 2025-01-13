public abstract class ApplicationController : Controller\n{\n    private IUserRepository _repUser;\n\n    public ApplicationController()\n    {\n        _repUser = RepositoryFactory.getUserRepository();\n    }\n\n    protected override void OnActionExecuting(ActionExecutingContext filterContext)\n    {\n        base.OnActionExecuting(filterContext);\n\n        if (User != null && User.Identity.IsAuthenticated)\n        {\n            var loggedInUser = _repUser.FindById(User.Identity.Name);\n            ViewData["LoggedInUser"] = loggedInUser;\n        }\n    }\n}