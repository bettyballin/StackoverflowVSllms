@using (Html.BeginForm("Action", "Controller", FormMethod.Post))\n{\n    @Html.AntiForgeryToken()\n    <!-- form fields -->\n}