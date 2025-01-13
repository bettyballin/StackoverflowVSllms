using System;\nusing System.Linq;\n\npublic class Product\n{\n    public decimal Price { get; set; }\n    public int Energy { get; set; }\n}\n\npublic class Knapsack\n{\n    private const int MAX_PRODUCTS = 15;\n    private const decimal MAX_PRICE = 10.0m;\n\n    public static int[] FindBestCombination(Product[] products)\n    {\n        var sortedProducts = products.OrderByDescending(p => p.Energy / p.Price).ToArray();\n\n        var dp = new int[sortedProducts.Length + 1, MAX_PRODUCTS + 1];\n\n        for (int i = 1; i <= sortedProducts.Length; i++)\n        {\n            for (int j = 1; j <= MAX_PRODUCTS; j++)\n            {\n                if (sortedProducts[i - 1].Price <= MAX_PRICE / j)\n                {\n                    dp[i, j] = Math.Max(dp[i - 1, j], dp[i - 1, j - 1] + sortedProducts[i - 1].Energy);\n                }\n                else\n                {\n                    dp[i, j] = dp[i - 1, j];\n                }\n            }\n        }\n\n        var result = new int[MAX_PRODUCTS];\n        int index = sortedProducts.Length, count = MAX_PRODUCTS;\n        while (count > 0)\n        {\n            if (dp[index, count] != dp[index - 1, count])\n            {\n                result[count - 1] = sortedProducts[index - 1].Energy;\n                count--;\n            }\n            index--;\n        }\n\n        return result;\n    }\n}