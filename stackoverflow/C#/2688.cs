if (integerList.Count > 0)\n{\n   //  pre C#8.0 : var item = integerList[integerList.Count - 1];\n   //  C#8.0 : \n   var item = integerList[^1];\n}