public class CustomHostHeaderModule : IHttpModule {\n    public void Init(HttpApplication context) {\n        context.BeginRequest += new EventHandler(OnBeginRequest);\n    }\n\n    private void OnBeginRequest(object sender, EventArgs e) {\n        HttpContext context = ((HttpApplication)sender).Context;\n        if (context.Request.Url.Host.Equals("abc.xyz.com")) {\n            context.RewritePath("~/sites/abc" + context.Request.Url.PathAndQuery, false);\n        }\n    }\n\n    public void Dispose() { }\n}