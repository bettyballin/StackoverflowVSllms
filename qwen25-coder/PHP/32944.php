<?php\n$foo = 'some words';\n\n// Case 1: Inline with double quotes\nprint "these are $foo";\n\n// Case 2: Inline with curly braces for clarity (not needed here, but useful in complex expressions)\nprint "these are {$foo}";\n\n// Case 3: Concatenation with single quotes\nprint 'these are ' . $foo;\n\n?>