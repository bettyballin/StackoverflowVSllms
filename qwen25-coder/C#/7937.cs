// Using MemoryCache in ASP.NET Core\n   var cacheEntryOptions = new MemoryCacheEntryOptions()\n       .SetSlidingExpiration(TimeSpan.FromMinutes(1));\n   \n   _memoryCache.Set("MyData", "Value", cacheEntryOptions);