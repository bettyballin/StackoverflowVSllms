// Instantiate MODX\nrequire_once '/path/to/modx/core/model/modx/modx.class.php';\n$modx = new modX();\n$modx->initialize('web');\n\n// Setting up the blog article data\n$postData = [\n    'pagetitle' => 'Your Post Title',\n    'introtext' => 'This is a short intro to your blog post.',\n    'content' => '<p>This is the main content of your blog post.</p>',\n    'alias' => 'your-post-title', // URL-friendly version of pagetitle\n    'published' => 1, // Publish it immediately\n    'template' => $articleTemplateId, // ID of your article template\n    // Additional fields like parent_id (parent container for blog posts)\n];\n\n// Create a new resource (blog post)\n$newResource = $modx->newObject('modResource');\n$newResource->fromArray($postData);\n$newResource->save();