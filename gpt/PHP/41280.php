<!-- templates/GuestBook/index.php -->\n\n<h1>Guest Book</h1>\n\n<!-- Display Guest Book Notes -->\n<div id="guest-book">\n    <h2>Guest Book Notes</h2>\n    <?php foreach ($guestBookNotes as $note): ?>\n        <div class="guest-book-note">\n            <p><?= h($note->content) ?></p>\n            <small>By <?= h($note->author) ?> on <?= h($note->created) ?></small>\n        </div>\n    <?php endforeach; ?>\n</div>\n\n<!-- Display News Posts -->\n<div id="news-box">\n    <h2>Latest News</h2>\n    <?php foreach ($newsPosts as $post): ?>\n        <div class="news-post">\n            <h3><?= h($post->title) ?></h3>\n            <p><?= h($post->content) ?></p>\n            <small>Posted on <?= h($post->created) ?></small>\n        </div>\n    <?php endforeach; ?>\n</div>\n\n<!-- Display Short Fact -->\n<div id="short-fact-box">\n    <h2>Did You Know?</h2>\n    <p><?= h($shortFacts->fact) ?></p>\n</div>