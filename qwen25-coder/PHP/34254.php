$args = array('post__in' => $postarray, 'orderby' => 'post__in');\n$query = new WP_Query($args);\n\nif ($query->have_posts()) :\n    while ($query->have_posts()) : $query->the_post();\n        the_title();\n        the_excerpt();\n    endwhile;\nendif;\n\n// Reset post data to avoid conflicts\nwp_reset_postdata();