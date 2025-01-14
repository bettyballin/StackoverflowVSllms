// Example safe usage of mb_strpos with UTF-8 encoding\n$haystack = "Héllo, wörld!";\n$needle = "Héllo";\n\n$position = mb_strpos($haystack, $needle, 0, 'UTF-8');\nif ($position !== false) {\n    echo "Found at position: $position";\n} else {\n    echo "Not found.";\n}