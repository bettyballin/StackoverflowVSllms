// application/configs/console.php\nreturn array(\n    'console' => array(\n        'router' => array(\n            'routes' => array(\n                'my-script' => array(\n                    'type' => 'simple',\n                    'options' => array(\n                        'route' => 'my-script',\n                        'defaults' => array(\n                            'controller' => 'MyScriptController',\n                            'action' => 'index'\n                        )\n                    )\n                )\n            )\n        )\n    )\n);