#!/bin/bash\n\n# Input and output file paths\ninput_file="source.pco"\noutput_file="processed_source.pco"\n\n# Add .pc extension if not present in EXEC SQL INCLUDE directives\nsed '/EXEC SQL INCLUDE /{\n    s/\(EXEC SQL INCLUDE [a-zA-Z0-9_]*\)\b[^.]*\>/\1.pc/\n}' "$input_file" > "$output_file"