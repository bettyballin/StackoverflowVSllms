$args = array(\n    'tax_query' => array(\n        array(\n            'taxonomy' => 'technologies',\n            'field'    => 'slug',\n            'terms'    => array('php', 'sql'),\n        ),\n    ),\n);\nquery_posts($args);