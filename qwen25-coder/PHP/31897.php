<?php\n\n// Database connection setup with PDO (example database: mysql)\n$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n\nfunction getArticleText($articleId, $pdo) {\n    $stmt = $pdo->prepare("SELECT content FROM articles WHERE id = ?");\n    $stmt->execute([$articleId]);\n    return $stmt->fetchColumn();\n}\n\nfunction getFormattedPages($text, $wordsPerPage) {\n    $pages = [];\n    $paragraphs = preg_split('/(?<=\n\s*\n)/', $text); // Split text into paragraphs\n    $currentPageWords = 0;\n    $currentPage = [];\n\n    foreach ($paragraphs as $paragraph) {\n        $paragraphWords = str_word_count($paragraph, 1);\n\n        if (count($currentPageWords + count($paragraphWords)) > $wordsPerPage && !empty($currentPage)) {\n            // Add current page to pages array\n            $pages[] = implode(' ', $currentPage);\n            // Reset for the next page\n            $currentPage = [];\n            $currentPageWords = 0;\n        }\n\n        // Add words of the paragraph to current page's word count\n        $currentPageWords += count($paragraphWords);\n        // Collect paragraph into current page content\n        $currentPage[] = $paragraph;\n    }\n\n    if (!empty($currentPage)) {\n        $pages[] = implode(' ', $currentPage);\n    }\n\n    return $pages;\n}\n\n$articleId = 1; // Example article ID\n$pageNumber = isset($_GET['page']) ? intval($_GET['page']) : 1;\n$wordsPerPage = 500; // Default words per page\n\n$text = getArticleText($articleId, $pdo);\nif ($text) {\n    $pages = getFormattedPages($text, $wordsPerPage);\n    \n    if (array_key_exists($pageNumber - 1, $pages)) {\n        echo nl2br($pages[$pageNumber - 1]); // Display requested page\n    } else {\n        echo "Page not found";\n    }\n} else {\n    echo "Article not found";\n}\n?>