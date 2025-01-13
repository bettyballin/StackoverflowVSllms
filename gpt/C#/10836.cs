using System;\nusing System.Collections;\nusing System.Collections.Generic;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    static void Main()\n    {\n        int Until = 20000000;\n        BitArray PrimeBits = new BitArray(Until, true);\n\n        PrimeBits.Set(0, false); // 0 is not a prime number\n        PrimeBits.Set(1, false); // 1 is not a prime number\n\n        int sqrtUntil = (int)Math.Sqrt(Until) + 1;\n\n        Parallel.For(2, sqrtUntil, P =>\n        {\n            if (PrimeBits.Get(P))\n            {\n                for (int PMultiply = P * P; PMultiply < Until; PMultiply += P)\n                {\n                    PrimeBits.Set(PMultiply, false);\n                }\n            }\n        });\n\n        List<int> Primes = new List<int>();\n        for (int i = 2; i < Until; i++)\n        {\n            if (PrimeBits.Get(i))\n            {\n                Primes.Add(i);\n            }\n        }\n\n        // Optional: Print the number of primes found\n        Console.WriteLine($"Number of primes found: {Primes.Count}");\n    }\n}