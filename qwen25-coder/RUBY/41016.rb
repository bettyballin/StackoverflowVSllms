@model IEnumerable<Comment>\n\n<ul id="comments">\n@foreach (var comment in Model)\n{\n    <li>@comment.Content</li>\n}\n</ul>