<?php\n$text = "This is a sample text containing word1 and word2.";\n$bad_words = array(\n    'word1' => 'gosh',\n    'word2' => 'darn',\n);\n\n// Separate the keys (bad words) and values (replacement words)\n$search = array_keys($bad_words);\n$replace = array_values($bad_words);\n\n// Perform the replacement\n$censored_text = str_replace($search, $replace, $text);\n\necho $censored_text;\n?>