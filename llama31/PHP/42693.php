// Item.php (model)\npublic function getDefaultImage() {\n    return $this->images->find('first', [\n        'conditions' => ['image_id' => $this->image_id],\n    ]);\n}