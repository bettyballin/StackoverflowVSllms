WebProxy proxy = new WebProxy(ProxyURL, ProxyPort);\nproxy.UseDefaultCredentials = true;\n\nmyWebService.Proxy = proxy;