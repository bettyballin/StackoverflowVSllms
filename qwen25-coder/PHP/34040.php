<?php\n/**\n * List Categories Alphabetically Grouped by Starting Letter\n */\n\n$categories = get_categories(array(\n    'orderby' => 'name',\n    'order'   => 'ASC',\n));\n\n$current_letter = '';\n\nforeach ($categories as $category) {\n    // Get the first letter of the category name\n    $first_letter = strtoupper(substr($category->name, 0, 1));\n    \n    // Output the new letter heading if it has changed\n    if ($current_letter !== $first_letter) {\n        echo '<p>"' . esc_html($first_letter) . '"</p>';\n        echo '<ul>';\n        $current_letter = $first_letter;\n    }\n    \n    // Output the category name within a list item\n    echo '<li>---<a href="' . esc_url(get_category_link($category->term_id)) . '">' . esc_html($category->name) . '</a></li>';\n}\n\n// Close the last ul if categories were printed\nif (!empty($categories)) {\n    echo '</ul>';\n}\n?>