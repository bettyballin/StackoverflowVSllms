void Application_AcquireRequestState(object sender, EventArgs e)\n{\n    if (HttpContext.Current.Session != null && !string.IsNullOrEmpty(HttpContext.Current.Request.QueryString["extendSession"]))\n    {\n        // Manually accessing session to reset timeout\n        HttpContext.Current.Session["Extend"] = DateTime.Now;\n\n        // Reset timeout logic (if needed, this might be redundant in this specific scenario)\n        if (bool.Parse(HttpContext.Current.Request.QueryString["extendSession"]))\n        {\n            HttpContext.Current.Session.Timeout = 30; // Set back to 30 minutes\n        }\n    }\n}