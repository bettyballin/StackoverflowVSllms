@if (Model.Bar != null)\n{\n    Html.RenderPartial("_Bar", Model.Bar);\n}\nelse\n{\n    Html.RenderPartial("_Bar", (string)null);\n}