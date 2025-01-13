public class RecentPostsViewComponent : ViewComponent\n{\n    private readonly IPostService _postService;\n\n    public RecentPostsViewComponent(IPostService postService)\n    {\n        _postService = postService;\n    }\n\n    public async Task<IViewComponentResult> InvokeAsync()\n    {\n        var recentPosts = await _postService.GetRecentPostsAsync();\n        return View(recentPosts);\n    }\n}