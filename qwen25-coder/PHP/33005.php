<?php\n\n// Initial arrays\n$measurements = [1469, 1465, 739, 849];\n$diffs = [0, 0, 0, 0];\n\n// Update the specific index in $diffs array\n$indexToUpdate = 2;\n$updateValue = 200;\n$diffs[$indexToUpdate] = $updateValue;\n\n// Subtract the updated difference from the corresponding measurement\n$measurements[$indexToUpdate] -= $diffs[$indexToUpdate];\n\n// Output the results\necho "Updated diffs: ";\nprint_r($diffs);\n\necho "Updated measurements: ";\nprint_r($measurements);\n\n?>