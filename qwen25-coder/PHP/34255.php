query_posts(array('post__in' => $postarray, 'orderby' => 'post__in'));\nif (have_posts()) :\n    while (have_posts()) : the_post();\n        the_title();\n        the_excerpt();\n    endwhile;\nendif;