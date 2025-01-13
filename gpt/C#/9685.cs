public static class RegistryCache\n{\n    private static readonly object _lock = new object();\n    private static string _cachedValue;\n    private static DateTime _lastRefreshTime;\n    private static readonly TimeSpan _cacheDuration = TimeSpan.FromMinutes(10);\n\n    public static string GetRegistryValue()\n    {\n        // Check if the cached value is still valid\n        if (_cachedValue == null || (DateTime.Now - _lastRefreshTime) > _cacheDuration)\n        {\n            lock (_lock)\n            {\n                // Double-check locking to ensure thread safety\n                if (_cachedValue == null || (DateTime.Now - _lastRefreshTime) > _cacheDuration)\n                {\n                    _cachedValue = ReadFromRegistry();\n                    _lastRefreshTime = DateTime.Now;\n                }\n            }\n        }\n\n        return _cachedValue;\n    }\n\n    private static string ReadFromRegistry()\n    {\n        using (Microsoft.Win32.RegistryKey key = Microsoft.Win32.Registry.LocalMachine.OpenSubKey("YourRegistryPath"))\n        {\n            if (key != null)\n            {\n                object value = key.GetValue("YourValueName");\n                return value != null ? value.ToString() : null;\n            }\n        }\n        return null;\n    }\n}