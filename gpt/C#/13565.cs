<!-- Views/Shared/Components/News/Default.cshtml -->\n@model IEnumerable<NewsArticle>\n\n<div>\n    <h2>Latest News</h2>\n    @foreach (var article in Model)\n    {\n        <p>@article.Title</p>\n        <p>@article.Summary</p>\n    }\n</div>