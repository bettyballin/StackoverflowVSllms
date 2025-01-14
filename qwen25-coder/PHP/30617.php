class CommentsPage extends Page {\n\n    function __construct($title = '')\n    {\n        parent::__construct();  // Ensure to call the constructor of the parent class if needed\n        $this->setTitle($title);  // Set the title using the passed article title.\n    }\n\n    function header()\n    {\n        parent::header();\n    }\n\n    function showAllComments($article_id, $param)\n    {\n        $article = Article::getById($article_id);\n        if (!empty($article))\n        {\n            ?>\n            <div class="news_item">\n                <a href="/index.php?action=vote&param=<?php echo htmlspecialchars($article->getId()); ?>"><img alt="vote button" class="vote_button" height="10" src="assets/images/vote2.png" width="10" class="border_less" /></a>\n                <h2 class="news_item_title"><b><a href = "<?php echo htmlspecialchars($article->getUrl()); ?>"><?php echo htmlspecialchars($article->getTitle()); ?></a></b></h2>\n                <span class="news_item_url">(<?php echo htmlspecialchars($article->getUrlDomain()); ?>)</span>\n                <div class="news_item_info"><?php $points = $article->getPoints(); echo $points > 1 ? "$points points" : "$points point"; ?> by <a href="/index.php?action=user&param=<?php echo htmlspecialchars($article->getUsername()); ?>"><?php echo htmlspecialchars($article->getUsername()); ?></a> <?php echo htmlspecialchars($article->getElapsedDateTime()); ?></div>\n                <p class="news_item_content"><?php echo htmlspecialchars($article->getDescription()); ?></p>\n            </div>\n            <?php\n            $this->showSubmitForm($article);\n        }\n    }\n}