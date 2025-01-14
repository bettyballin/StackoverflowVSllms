function create_custom_post_types() {\n    // Articles Custom Post Type\n    register_post_type('articles',\n        array(\n            'labels' => array(\n                'name' => __('Articles'),\n                'singular_name' => __('Article')\n            ),\n            'public' => true,\n            'rewrite' => array('slug' => 'discussed', 'with_front' => false),\n            'has_archive' => 'discusses'\n        )\n    );\n\n    // Portfolio Custom Post Type\n    register_post_type('portfolio',\n        array(\n            'labels' => array(\n                'name' => __('Portfolio'),\n                'singular_name' => __('Design')\n            ),\n            'public' => true,\n            'rewrite' => array('slug' => 'designed', 'with_front' => false),\n            'has_archive' => 'does'\n        )\n    );\n}\nadd_action('init', 'create_custom_post_types');