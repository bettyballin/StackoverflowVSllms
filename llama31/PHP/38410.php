// In config/autoload/routes.global.php\n'admin' => [\n    'type' => 'Segment',\n    'options' => [\n        'route' => '/admin[/:controller[/:action]]',\n        'defaults' => [\n            'module' => 'Admin',\n            'controller' => 'Dashboard',\n            'action' => 'index',\n        ],\n    ],\n],