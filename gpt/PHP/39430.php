$categories = [\n    [\n        'Category' => [\n            'id' => 1,\n            'name' => 'General',\n            'status' => 1,\n            'order' => 1\n        ],\n        'Forum' => [\n            [\n                'id' => 1,\n                'category_id' => 1,\n                'name' => 'Lounge',\n                'description' => 'Go and lounge around',\n                'status' => 1,\n                'order' => 1,\n                'total_posts' => 1,\n                'total_threads' => 1,\n                'created' => '2009-06-04 19:13:24'\n            ],\n            [\n                'id' => 2,\n                'category_id' => 1,\n                'name' => 'Test111',\n                'description' => 'Test111',\n                'status' => 1,\n                'order' => 1,\n                'total_posts' => 1,\n                'total_threads' => 1,\n                'created' => '2009-06-04 19:16:26'\n            ]\n        ]\n    ]\n];\n\nforeach ($categories as $category) {\n    echo "Category: " . $category['Category']['name'] . "\n";\n\n    foreach ($category['Forum'] as $forum) {\n        echo "  Forum: " . $forum['name'] . "\n";\n        echo "    Description: " . $forum['description'] . "\n";\n        echo "    Total Posts: " . $forum['total_posts'] . "\n";\n        echo "    Total Threads: " . $forum['total_threads'] . "\n";\n        echo "    Created: " . $forum['created'] . "\n";\n    }\n}