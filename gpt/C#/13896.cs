<!-- Views/Shared/_Layout.cshtml -->\n<!DOCTYPE html>\n<html>\n<head>\n    <title>@ViewBag.Title</title>\n    <!-- Add your other head elements here -->\n</head>\n<body>\n    <div class="container">\n        <table>\n            <tr>\n                <td style="vertical-align: top;">\n                    @Html.Partial("_Menu")\n                </td>\n                <td style="vertical-align: top;">\n                    @RenderBody()\n                </td>\n            </tr>\n        </table>\n    </div>\n</body>\n</html>