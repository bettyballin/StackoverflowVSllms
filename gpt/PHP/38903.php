<?php\nfunction replace_apostrophes($input) {\n    // Replace HTML numeric equivalent of apostrophe with real apostrophe\n    $output = str_replace(array("&#39;", "&apos;"), "'", $input);\n    return $output;\n}\n\n$input_string = "Here&#39;s an example with an apostrophe&#39;s HTML equivalent.";\n$corrected_string = replace_apostrophes($input_string);\n\necho $corrected_string;  // Output: Here's an example with an apostrophe's HTML equivalent.\n?>