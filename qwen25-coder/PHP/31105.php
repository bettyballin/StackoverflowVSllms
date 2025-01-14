function wordsRhyme($word1, $word2) {\n    return metaphone($word1) === metaphone($word2);\n}\n\n// Example usage\n$word1 = "knight";\n$word2 = "light";\n\nif (wordsRhyme($word1, $word2)) {\n    echo "$word1 and $word2 rhyme phonetically.";\n} else {\n    echo "$word1 and $word2 do not rhyme phonetically.";\n}