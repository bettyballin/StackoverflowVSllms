<?php $query = new WP_Query('category_name=code'); ?>  \n<?php while ($query->have_posts()) : $query->the_post(); ?>\n<!-- display the category here --> \n<?php endwhile; ?>