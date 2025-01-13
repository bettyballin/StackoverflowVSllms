using System.Diagnostics;\n\npublic class CacheSizeMonitor\n{\n    public static long GetCacheSize()\n    {\n        var pc = new PerformanceCounter("ASP.NET Applications", "Cache Bytes", "_Total", true);\n        return pc.NextSample().RawValue;\n    }\n}