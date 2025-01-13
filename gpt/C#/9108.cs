using System;\nusing System.Collections.Generic;\n\npublic static class Memoization\n{\n    public static Func<T, TResult> Memoize<T, TResult>(this Func<T, TResult> func)\n    {\n        var cache = new Dictionary<T, TResult>();\n        return arg =>\n        {\n            if (cache.TryGetValue(arg, out var result))\n            {\n                return result;\n            }\n            result = func(arg);\n            cache[arg] = result;\n            return result;\n        };\n    }\n}\n\npublic class Example\n{\n    private static int ComputeStuff(int x)\n    {\n        // Simulate a CPU-intensive computation\n        return x * x; // Example computation\n    }\n\n    public static void Main()\n    {\n        var memoizedComputeStuff = new Func<int, int>(ComputeStuff).Memoize();\n\n        Console.WriteLine(memoizedComputeStuff(5)); // Computed and cached\n        Console.WriteLine(memoizedComputeStuff(5)); // Retrieved from cache\n    }\n}