<?php \n\n$my_other_query = new WP_Query('category_name=posts&showposts=1');\n\nwhile ($my_other_query->have_posts()) : $my_other_query->the_post();\n echo get_post_meta($post->ID, "qanda", true); \n endwhile; \n?>