<% using (Html.BeginForm("test_ajax", "Company", FormMethod.Post, new { id = "myForm" })) { %>\n    <%= Ajax.ActionLink("Go!", "test_ajax", \n        new AjaxOptions { \n            UpdateTargetId = "viewport", \n            HttpMethod = "POST", \n            FormId = "myForm" \n        }) %>\n    <div id="viewport">Replace me!</div>\n<% } %>