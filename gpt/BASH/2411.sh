# Compilation with profiling instrumentation\n    g++ -fprofile-generate source.cpp -o program\n    ./program   # Run the program to generate profile data\n\n    # Compilation using the collected profile data\n    g++ -fprofile-use source.cpp -o optimized_program