void context_EndRequest(object sender, EventArgs e)\n    {\n        var app = sender as HttpApplication;\n        var response = app.Response;\n        var request = app.Request;\n\n        if ((response.StatusCode == 302) && IsAjaxRequest(request))\n            response.StatusCode = 401;\n    }