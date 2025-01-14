<?php\nfunction uploadfolder($x) {\n    $limit_per_folder = 10; // Number of files per folder\n    $total_divisor = $limit_per_folder * $limit_per_folder;\n    \n    // Calculate the first level directory (main folder)\n    $dir = floor($x / ($total_divisor * $limit_per_folder)) + 1;\n    \n    // Calculate the second level directory (subfolder)\n    $sdir = floor(($x % ($total_divisor * $limit_per_folder)) / $total_divisor) + 1;\n    \n    // Calculate the third level directory (sub-subfolder)\n    $ssdir = ($x % $total_divisor) % $limit_per_folder == 0 ? $limit_per_folder : ($x % $total_divisor) % $limit_per_folder;\n    \n    return "$dir/$sdir/$ssdir";\n}\n?>