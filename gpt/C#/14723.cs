// NewsViewComponent.cs\npublic class NewsViewComponent : ViewComponent\n{\n    private readonly INewsService _newsService;\n\n    public NewsViewComponent(INewsService newsService)\n    {\n        _newsService = newsService;\n    }\n\n    public async Task<IViewComponentResult> InvokeAsync()\n    {\n        var news = await _newsService.GetLatestNewsAsync();\n        return View(news);\n    }\n}