<?php \n$d = date("D"); \nif (in_array($d, array('Thu','Fri','Sat','Sun'))) {\n    echo "The latest post for Thursday, Friday, Saturday, Sunday:<br />";\n    $my_query = new WP_Query('category_name=posts&showposts=1'); \n    while ($my_query->have_posts()) : $my_query->the_post(); ?>\n        <a href="<?php the_permalink() ?>" rel="bookmark"><?php the_title(); ?></a>.<br />\n    <?php endwhile; \n} ?>