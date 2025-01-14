<?php\nfunction getLowestNumbers($numbers, $n = 10) {\n    if (count($numbers) <= $n) {\n        sort($numbers);\n        return $numbers;\n    }\n\n    $minHeap = new SplMinHeap();\n\n    foreach ($numbers as $number) {\n        if ($minHeap->count() < $n) {\n            $minHeap->insert($number);\n        } elseif ($number < $minHeap->top()) {\n            $minHeap->extract();\n            $minHeap->insert($number);\n        }\n    }\n\n    $result = [];\n    foreach ($minHeap as $number) {\n        $result[] = $number;\n    }\n\n    sort($result);\n    return $result;\n}\n\n// Example usage\n$numbers = [5, 1, 9, 3, 7, 2, 8, 6, 4, 10, 11, 12, -1, 0];\n$lowestNumbers = getLowestNumbers($numbers);\nprint_r($lowestNumbers);\n?>