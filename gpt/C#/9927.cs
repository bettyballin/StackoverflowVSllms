protected void Application_Start()\n{\n    RouteTable.Routes.Ignore("{resource}.axd/{*pathInfo}");\n    RouteTable.Routes.IgnoreRoute("{*allaspx}", new { allaspx = @".*\.aspx(/.*)?" });\n}