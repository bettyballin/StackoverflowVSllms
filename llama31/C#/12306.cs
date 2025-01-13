@model YourModel\n\n// Items per Page drop down\n@Html.DropDownListFor(m => m.ItemsPerPage, new SelectList(new[] { 10, 25, 50 }, Model.ItemsPerPage), new { @class = "form-control", id = "itemsPerPage" })\n\n// Product Display area\n<div id="productDisplay">\n    @Html.Partial("_ProductDisplay", Model.Products)\n</div>\n\n<script>\n    $(document).ready(function () {\n        $('#itemsPerPage').on('change', function () {\n            var itemsPerPage = $(this).val();\n            $.ajax({\n                type: 'POST',\n                url: '@Url.Action("UpdateProductDisplay", "YourController")',\n                data: { itemsPerPage: itemsPerPage },\n                success: function (data) {\n                    $('#productDisplay').html(data);\n                }\n            });\n        });\n    });\n</script>