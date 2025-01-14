// Instead of manually implementing a stack, use PHP's SplStack\n$stack = new SplStack();\n$stack->push("Item 1");\n$stack->push("Item 2");\n\necho $stack->pop(); // Outputs "Item 2"\necho $stack->pop(); // Outputs "Item 1"\n\n// Using SplFixedArray for a fixed-size array\n$array = new SplFixedArray(5);\n$array[0] = 'A';\n$array[4] = 'E';\n\nforeach ($array as $item) {\n    echo $item; // Outputs "ABCDE"\n}