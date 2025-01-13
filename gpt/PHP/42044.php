$cat = null;\n$dog = "dog";\n$fruit = "apple";\n$vegetable = "carrot";\n\n// Using logical operators\n$foo = $cat && $dog;  // $foo will be false\n$bar = $fruit || $vegetable;  // $bar will be "apple"\n\n// Using ternary operator\n$foo = $cat ? $dog : null;  // $foo will be null\n$bar = $fruit ? $fruit : $vegetable;  // $bar will be "apple"\n\n// Using null coalescing operator\n$foo = $cat ?? $dog;  // $foo will be "dog"\n$bar = $fruit ?? $vegetable;  // $bar will be "apple"