$array = [\n    1510790277,\n    1586522582,\n    1572272336,\n    1650049585,\n    1591332330,\n    1698088238,\n    1646561226,\n    1639050043,\n    1652067570,\n    1548161804,\n];\n\narsort($array); // Sort the array in descending order, maintaining key association\n$indexesOfLargest = array_keys(array_slice($array, 0, 3)); // Get keys of the largest 3 elements\n\necho implode(", ", $indexesOfLargest); // Outputs: 5, 8, 3