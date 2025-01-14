<?php\n\nfunction bestFitLine(array $points) {\n    $n = count($points);\n    if ($n === 0) return ['m' => 0, 'b' => 0];\n\n    $sumX = 0;\n    $sumY = 0;\n    $sumXY = 0;\n    $sumX2 = 0;\n\n    foreach ($points as $point) {\n        list($x, $y) = $point;\n        $sumX += $x;\n        $sumY += $y;\n        $sumXY += $x * $y;\n        $sumX2 += $x * $x;\n    }\n\n    $m = ($n * $sumXY - $sumX * $sumY) / ($n * $sumX2 - pow($sumX, 2));\n    $b = ($sumY - $m * $sumX) / $n;\n\n    return ['m' => $m, 'b' => $b];\n}\n\n// Example usage:\n$points = [\n    [1, 2],\n    [2, 3],\n    [4, 5],\n    [5, 6]\n];\n\n$result = bestFitLine($points);\necho "Best fit line: y = {$result['m']}x + {$result['b']}\n";\n\n?>