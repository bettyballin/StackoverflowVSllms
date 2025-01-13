$popularEntries = $this->Entry->find('all', array(\n  'conditions' => array(\n    'Comment.created BETWEEN ? AND ?' => array(\n      date('Y-m-d H:i:s', strtotime('-1 month')),\n      date('Y-m-d H:i:s')\n    )\n  ),\n  'joins' => array(\n    array(\n      'table' => 'comments',\n      'alias' => 'Comment',\n      'type' => 'LEFT',\n      'conditions' => array(\n        'Entry.id = Comment.entry_id'\n      )\n    )\n  ),\n  'group' => array('Entry.id', 'Entry.title'),\n  'order' => array('COUNT(Comment.id) DESC'),\n  'limit' => 10\n));