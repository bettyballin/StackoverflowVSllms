<h1><?=$title?></h1>\n<p><?=$text?></p>\n\n<h1>Replies</h1>\n\n<?php foreach ($replies as $reply): ?>\n    <p><?=$reply['text']?></p>\n    <p>Posted by <?=$reply['poster']?> on <?=$reply['date']?></p>\n    <?php if ($reply['edited']): ?>\n        <p>Last edited on <?=$reply['edited']?></p>\n    <?php endif; ?>\n<?php endforeach; ?>