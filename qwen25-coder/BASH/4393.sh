clang++ -fsanitize-coverage=trace-pc-guard foo.cpp -o foo\n   ./foo\n   llvm-profdata merge default.profraw -o foo.profdata\n   llvm-cov show ./foo -instr-profile=foo.profdata