<table>\n<?php foreach ($rows as $row): ?>\n    <tr>\n    <?php if ($row->foo()): ?>\n        <?php echo $row ?>\n    <?php else: ?>\n        Something else\n    <?php endif ?>\n    </tr>\n<?php endforeach ?>\n</table>