using System;\nusing System.Collections.Generic;\n\npublic class PrimeFactors\n{\n    public static List<long> GetPrimeFactors(long number)\n    {\n        List<long> primeFactors = new List<long>();\n\n        // Divide by 2\n        while (number % 2 == 0)\n        {\n            primeFactors.Add(2);\n            number /= 2;\n        }\n\n        // Divide by odd numbers up to the square root of the number\n        for (long i = 3; i * i <= number; i += 2)\n        {\n            while (number % i == 0)\n            {\n                primeFactors.Add(i);\n                number /= i;\n            }\n        }\n\n        // If the remaining number is a prime number greater than 2\n        if (number > 2)\n        {\n            primeFactors.Add(number);\n        }\n\n        return primeFactors;\n    }\n\n    public static void Main()\n    {\n        long number = 600851475143;\n        List<long> primeFactors = GetPrimeFactors(number);\n        Console.WriteLine("Prime factors:");\n        foreach (var primeFactor in primeFactors)\n        {\n            Console.WriteLine(primeFactor);\n        }\n    }\n}