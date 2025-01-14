function findTenLowestNumbers(array $numbers) {\n    // Initialize an array to hold the lowest 10 numbers, filled with max int values\n    $lowestNumbers = array_fill(0, 10, PHP_INT_MAX);\n\n    foreach ($numbers as $number) {\n        // If the current number is smaller than the largest in our lowest set\n        if ($number < max($lowestNumbers)) {\n            // Find the index of the maximum value in the lowest numbers array\n            $maxIndex = array_search(max($lowestNumbers), $lowestNumbers);\n            // Replace it with the new lower number\n            $lowestNumbers[$maxIndex] = $number;\n            // Sort the array to ensure the highest is at the end again\n            rsort($lowestNumbers);\n        }\n    }\n\n    return $lowestNumbers;\n}\n\n// Example usage:\n$numbers = range(1, 1000); // An example with numbers from 1 to 1000\nshuffle($numbers); // Shuffle to ensure randomness\necho implode(", ", findTenLowestNumbers($numbers)); // Output: The lowest 10 unique numbers