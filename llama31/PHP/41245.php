Route::set('article', '(<title>[a-zA-Z0-9\-/]+)', array(\n    'controller' => 'Articles',\n    'action' => 'view'\n));