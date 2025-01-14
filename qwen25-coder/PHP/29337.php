<?php\n// Sample data from MySQL (for demonstration)\n$packages = [3, 4, 1, 3, 4];\n\n// Mapping of package numbers to their corresponding values\n$packageValues = [\n    1 => 1,\n    3 => 5,\n    4 => 10,\n];\n\n// Calculate the total value\n$totalValue = 0;\nforeach ($packages as $package) {\n    if (isset($packageValues[$package])) {\n        $totalValue += $packageValues[$package];\n    }\n}\n\necho "The total value is: $" . $totalValue;\n?>