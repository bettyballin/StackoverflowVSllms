HttpContext.Current.Response.ContentType = "image/jpeg";\n\n// Write the image bytes to the response\nHttpContext.Current.Response.BinaryWrite(imageBytes);\n\n// Set cacheability to public\nHttpContext.Current.Response.Cache.SetCacheability(HttpCacheability.Public);\n\n// Allow response to be stored in the browser history\nHttpContext.Current.Response.Cache.SetAllowResponseInBrowserHistory(true);\n\n// Set the ETag header\nHttpContext.Current.Response.Cache.SetETag("\"" + imgRepGetCache.DateCached.ToString("yyyyMMddHHmmss") + "\"");\n\n// Set the Last-Modified header if DateCached is available\nif (imgRepGetCache.DateCached.HasValue)\n    HttpContext.Current.Response.Cache.SetLastModified(imgRepGetCache.DateCached.Value);\n\n// Set the Expires header to 2 days from now\nHttpContext.Current.Response.Cache.SetExpires(DateTime.Now.AddDays(2));\n\n// Ensure the response is not considered stale immediately\nHttpContext.Current.Response.Cache.SetValidUntilExpires(true);\n\n// End the response\nHttpContext.Current.Response.End();