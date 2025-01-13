public class RecentPostsController : Controller\n{\n    [ChildActionOnly]\n    public PartialViewResult RecentPosts()\n    {\n        var recentPosts = GetRecentPostsFromDatabase();\n        return PartialView("_RecentPosts", recentPosts);\n    }\n\n    private RecentPostsModel GetRecentPostsFromDatabase()\n    {\n        // retrieve data from database\n        return new RecentPostsModel { Posts = ... };\n    }\n}