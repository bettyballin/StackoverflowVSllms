function beforeRender() {\n    $this->Session->flash('default', array(\n        'element' => 'layout_flash'\n    ));\n}