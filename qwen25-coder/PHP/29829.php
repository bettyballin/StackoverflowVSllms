<?php\n// Set the parent category ID\n$parent_category_id = 10; // Replace with your category ID\n\n$args = array(\n    'cat' => $parent_category_id,\n    'orderby' => 'date',\n    'order' => 'DESC',\n    'posts_per_page' => -1, // Retrieve all posts\n    'showposts' => -1, // Optional, shows all posts\n    'post_status' => 'publish'\n);\n\n// Custom query to fetch only the category's posts and its child categories\n$query = new WP_Query( $args );\n\nif ( $query->have_posts() ) {\n    echo '<ul>';\n    while ( $query->have_posts() ) {\n        $query->the_post();\n        ?>\n        <li>\n            <a href="<?php the_permalink(); ?>"><?php the_title(); ?></a>\n        </li>\n        <?php\n    }\n    echo '</ul>';\n} else {\n    echo 'No posts found in this category.';\n}\n\n// Reset post data to avoid conflicts with other queries\nwp_reset_postdata();\n?>