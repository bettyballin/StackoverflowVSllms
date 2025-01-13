enum Flags: int {\n    case A = 1;\n    case B = 2;\n    case C = 4;\n}\n\n$flags = [Flags::A, Flags::C];\n\nif (in_array(Flags::A, $flags)) {\n    echo "FLAG_A is set";\n}\n\nif (in_array(Flags::B, $flags)) {\n    echo "FLAG_B is set"; // This won't be executed\n}