<?php\n$post_count = 0;\nif ( have_posts() ) : while ( have_posts() ) : the_post();\n    $post_count++;\n    // Your post markup here\n\n    if ($post_count % 3 == 0) { ?>\n        <!-- ad code -->\n    <?php }\nendwhile; endif;\n?>