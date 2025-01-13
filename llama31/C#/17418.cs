using BenchmarkDotNet.Attributes;\nusing BenchmarkDotNet.Diagnostics.Windows.Configs;\nusing BenchmarkDotNet.Engines;\nusing BenchmarkDotNet.Jobs;\n\n[SimpleJob(RunStrategy.Monitoring, Baseline = true)]\n[MemoryDiagnoser]\npublic class MathBenchmark\n{\n    private double[] array;\n\n    [GlobalSetup]\n    public void Setup()\n    {\n        array = new double[1000000];\n        for (int i = 0; i < array.Length; i++)\n        {\n            array[i] = Random.Shared.NextDouble();\n        }\n    }\n\n    [Benchmark]\n    public double MathOperations()\n    {\n        double sum = 0;\n        foreach (double d in array)\n        {\n            sum += Math.Sqrt(d) * Math.Sin(d);\n        }\n        return sum;\n    }\n}