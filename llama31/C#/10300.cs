void application_BeginRequest(object sender, EventArgs e)\n{\n    HttpContext context = HttpContext.Current;\n    if (context.Request.RawUrl.Contains(".pox")) \n    {\n        context.RewritePath("~/Lab1Service.svc?format=pox", false);\n        ((HttpApplication)sender).Execute("~/Lab1Service.svc?format=pox", context.Request.HttpMethod, context.Request.Headers, context.Request.InputStream);\n    }\n    else if (context.Request.RawUrl.Contains(".json")) \n    {\n        context.RewritePath("~/Lab1Service.svc?format=json", false);\n        ((HttpApplication)sender).Execute("~/Lab1Service.svc?format=json", context.Request.HttpMethod, context.Request.Headers, context.Request.InputStream);\n    }\n}