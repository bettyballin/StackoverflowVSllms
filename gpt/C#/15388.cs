// Infinite loop\nfor(;;) {\n    // Loop body\n}\n\n// Loop without initialization\nint i = 0;\nfor(; i < 10; i++) {\n    Console.WriteLine(i);\n}\n\n// Loop without condition (infinite loop unless there is a break)\nfor(int j = 0;; j++) {\n    if (j == 10) break;\n    Console.WriteLine(j);\n}\n\n// Loop without iteration expression\nfor(int k = 0; k < 10;) {\n    Console.WriteLine(k);\n    k++;\n}