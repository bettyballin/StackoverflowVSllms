<?php \n$c = 0;\nforeach($posts as $post){ ?>\n    <div class="<?php echo ($c++ % 2 == 1) ? 'odd' : '' ?>">\n        <?php echo htmlspecialchars($post); ?>\n    </div>\n<?php } ?>\n\n<style>\n.odd { background-color: red; }\n</style>