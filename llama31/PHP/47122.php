// Get the article\n$articleId = 1; // Replace with the ID of your article "Article 1"\n$category = 'Cat';\n$section = 'Test';\n\n$article = JModel::getInstance('Content', 'JModel');\n$article->setState('filter.id', $articleId);\n$article->setState('filter.category', $category);\n$article->setState('filter.section', $section);\n\n$article->getItem();\n\n// Get the article title and text\n$title = $article->get('title');\n$text = $article->get('text');\n\n// Truncate the text to 100 words\n$text = substr($text, 0, 100);\n\n// Create the "Read more" link\n$readMoreLink = JRoute::_(ContentHelperRoute::getArticleRoute($articleId, $category, $section));\n\n// Display the article title, text, and "Read more" link\n?>\n<h2><?php echo $title; ?></h2>\n<p><?php echo $text; ?></p>\n<p><a href="<?php echo $readMoreLink; ?>">Read more...</a></p>