<?php\n// Load WordPress Environment\nrequire_once("/path/to/your/wordpress/wp-load.php");\n\nget_header(); // Outputs the header\n?>\n\n<div class="main-content">\n    <!-- Your custom content goes here -->\n    <p>This is a custom page outside of WordPress!</p>\n</div>\n\n<?php\nwp_nav_menu(); // Outputs the main navigation menu\nget_footer(); // Outputs the footer\n?>