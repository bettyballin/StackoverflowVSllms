<?php foreach ($view->result as $row): ?>\n  <?php print $view->rowPlugin->render($row); ?>\n<?php endforeach; ?>