<h1><?php echo $title; ?></h1>\n<p><?php echo $text; ?></p>\n\n<h1>Replies</h1>\n<?php foreach ($replies as $reply): ?>\n    <div>\n        <p><?php echo $reply['text']; ?></p>\n        <small>Posted by <?php echo $reply['poster']; ?> on <?php echo $reply['date']; ?>\n            <?php if (!empty($reply['edited'])): ?>\n                (Edited on <?php echo htmlspecialchars($reply['edited']); ?>)\n            <?php endif; ?>\n        </small>\n    </div>\n<?php endforeach; ?>