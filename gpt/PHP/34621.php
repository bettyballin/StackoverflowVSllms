<?php\n$bad_words = array(\n    'word1' => 'gosh',\n    'word2' => 'darn',\n);\n\n$text = "This is some text with word1 and another word2.";\n\n// Replace bad words\n$clean_text = str_ireplace(array_keys($bad_words), array_values($bad_words), $text);\n\necho $clean_text;\n?>