void example_function(int a) {\n    asm volatile (\n        "sw $ra, -4($sp)\n\t" // Save the return address\n        "addiu $sp, $sp, -20\n\t" // Allocate 16 bytes (for 4 words) on stack for local variables\n        "addiu $sp, $sp, 20\n\t" // De-allocate stack space\n        "lw $ra, 0($sp)\n\t" // Restore return address from the stack\n    );\n}