[HandleError]\n    public class BaseController : Controller\n    {\n        CourseService cs = new CourseService();\n        protected override void OnActionExecuting(ActionExecutingContext filterContext)\n        {\n            List<Tag> tags = cs.GetTags();\n            ViewData["Tags"] = tags;\n        }\n\n    }