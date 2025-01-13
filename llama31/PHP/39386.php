require_once __DIR__ . '/vendor/autoload.php';\n\n$hybridauth = new Hybridauth\Hybridauth([\n  'providers' => [\n    'Google' => [\n      'enabled' => true,\n      'keys' => [\n        'id' => 'YOUR_CLIENT_ID',\n        'secret' => 'YOUR_CLIENT_SECRET',\n      ],\n    ],\n    'Facebook' => [\n      'enabled' => true,\n      'keys' => [\n        'id' => 'YOUR_APP_ID',\n        'secret' => 'YOUR_APP_SECRET',\n      ],\n    ],\n  ],\n]);\n\nif (isset($_GET['provider'])) {\n  $provider = $_GET['provider'];\n  $hybridauth->authenticate($provider);\n  // Use the authenticated user's profile information to authenticate them\n}