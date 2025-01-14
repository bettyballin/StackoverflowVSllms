// Pseudo-code logic for syncing articles\n\nfunction fetchWikiArticles() {\n    // Assume this function fetches all articles from the Wiki application database\n}\n\nfunction createBlogPostFromWikiArticle($article) {\n    global $wpdb;\n    \n    // Insert a new post into WordPress based on the content of the Wiki article\n    $newPostID = wp_insert_post(array(\n        'post_title' => $article['title'],\n        'post_content' => $article['content'],\n        'post_status'  => 'publish',\n        'post_author'  => 1, // Admin user ID or dynamic author assignment logic\n        'category'                       => array(5),  // Assuming category ID is 5 \n    ));\n    \n    return $newPostID;\n}\n\nfunction syncWikiToBlog() {\n    $wikiArticles = fetchWikiArticles();\n    foreach ($wikiArticles as $article) {\n        createBlogPostFromWikiArticle($article);\n    }\n}