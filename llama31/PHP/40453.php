Route::set('posts_create', '(<controller>(/<action>(/<id>)))')\n    ->defaults(array(\n        'controller' => 'posts',\n        'action'     => 'create',\n    ))\n    ->methods('POST');