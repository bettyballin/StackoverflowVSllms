function splitArticleIntoPages($articleContent, $wordsPerPage) {\n    $pages = [];\n    $wordCount = 0;\n    $currentPageContent = '';\n\n    $paragraphs = explode("\n\n", $articleContent);\n    foreach ($paragraphs as $paragraph) {\n        $wordsInParagraph = count(explode(' ', $paragraph));\n        if ($wordCount + $wordsInParagraph > $wordsPerPage) {\n            // If adding this paragraph would exceed the word limit, start a new page\n            $pages[] = [\n                'start_word_index' => $wordCount,\n                'end_word_index' => $wordCount + $wordsInParagraph,\n                'content' => $currentPageContent,\n            ];\n            $currentPageContent = $paragraph;\n            $wordCount = $wordsInParagraph;\n        } else {\n            // Add the paragraph to the current page\n            $currentPageContent .= $paragraph . "\n\n";\n            $wordCount += $wordsInParagraph;\n        }\n    }\n\n    // Add the last page\n    $pages[] = [\n        'start_word_index' => $wordCount,\n        'end_word_index' => $wordCount + $wordsInParagraph,\n        'content' => $currentPageContent,\n    ];\n\n    return $pages;\n}