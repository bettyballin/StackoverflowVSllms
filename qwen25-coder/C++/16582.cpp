void func(int x = 10) {}\nvoid func(double x = 3.14) {}\n\n// Calling without parameters\nfunc(); // Error: Call is ambiguous between 'void func(int)' and 'void func(double)'