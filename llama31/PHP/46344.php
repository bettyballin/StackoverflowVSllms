function eastern_arabic_numerals($content) {\n  $eastern_numerals = array('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩');\n  $western_numerals = array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');\n  return str_replace($western_numerals, $eastern_numerals, $content);\n}\n\nadd_filter('the_date', 'eastern_arabic_numerals');\nadd_filter('wp_link_pages', 'eastern_arabic_numerals');