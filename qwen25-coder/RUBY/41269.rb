<select onchange="location.href='<%= Url.Action("Accounts", "Authorized", new { area = "Manager"}, Url.ActionContext.HttpContext.Request.Url.Scheme) %>/' + this.value">\n    @* Options here *@\n</select>