$number;\ndo {\n    $number = rand(0, 99);\n} while ($number % 9 == 0);\n\necho "Random number that is not divisible by 9: $number";