public static List<int> Randomise(List<int> list, Func<bool> randomSwap)\n{\n    foreach(int i in list)\n    {\n        if (randomSwap)\n        {\n            //swap i and i+1;\n        }\n    }\n    return list;\n}