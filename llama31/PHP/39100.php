<?php\n/*\nTemplate Name: Archive Template\n*/\n\nquery_posts(array(\n    'posts_per_page' => -1, // Show all posts\n    'orderby' => 'date', // Order by date\n    'order' => 'DESC' // Order in descending order\n));\n\n$prev_month = '';\n$prev_year = '';\n\nwhile (have_posts()) : the_post();\n\n    $current_month = get_the_time('F');\n    $current_year = get_the_time('Y');\n\n    if ($current_month != $prev_month || $current_year != $prev_year) {\n        if ($prev_month != '') {\n            echo '</ul>';\n        }\n        echo '<h2>' . $current_month . ' ' . $current_year . '</h2>';\n        echo '<ul>';\n    }\n\n    echo '<li><a href="' . get_permalink() . '">' . get_the_title() . '</a></li>';\n\n    $prev_month = $current_month;\n    $prev_year = $current_year;\n\nendwhile;\n\necho '</ul>';\n\n?>