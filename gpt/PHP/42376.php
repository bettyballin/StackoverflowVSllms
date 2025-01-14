$select = $this->select()\n    ->setIntegrityCheck(false)\n    ->from(array('post' => 'Posts'), array(\n        'post_id' => 'idPost',\n        'post_idTopic' => 'idTopic',\n        'post_idGroup' => 'idGroup',\n        'post_idUser' => 'idUser',\n        'post_content' => 'postContent',\n        'post_url' => 'postUrl',\n        'post_votes' => 'postVotes',\n        'post_score' => 'postScore',\n        'post_date' => 'date'\n    ))\n    ->where('post.idGroup = ?', $idGroup)\n    ->where('post.idTopic IS NULL')\n    ->order('post.date DESC')\n    ->limit($resultsPerPage, $resultsPerPage * ($page - 1))\n    ->joinLeft(array('user' => 'Users'), 'post.idUser = user.idUser', array(\n        'user_id' => 'idUser',\n        'user_fname' => 'fname',\n        'user_lname' => 'lname',\n        'user_profileUrl' => 'profileUrl',\n        'user_photoUrl' => 'photoUrl'\n    ))\n    ->joinLeft(array('comment' => 'Posts'), 'comment.idTopic = post.idPost', array(\n        'comment_id' => 'idPost',\n        'comment_content' => 'postContent',\n        'comment_idGroup' => 'idGroup',\n        'comment_date' => 'date'\n    ));\n\n$results = $select->query()->fetchAll();\n\n// Organize the results into a hierarchical array\n$organizedResults = [];\nforeach ($results as $row) {\n    $postId = $row['post_id'];\n    if (!isset($organizedResults[$postId])) {\n        $organizedResults[$postId] = [\n            'post' => [\n                'idPost' => $row['post_id'],\n                'postContent' => $row['post_content'],\n                'idGroup' => $row['post_idGroup'],\n                'postUrl' => $row['post_url'],\n                'postVotes' => $row['post_votes'],\n                'postScore' => $row['post_score'],\n                'date' => $row['post_date']\n            ],\n            'user' => [\n                'idUser' => $row['user_id'],\n                'fname' => $row['user_fname'],\n                'lname' => $row['user_lname'],\n                'profileUrl' => $row['user_profileUrl'],\n                'photoUrl' => $row['user_photoUrl']\n            ],\n            'comments' => []\n        ];\n    }\n    if ($row['comment_id']) {\n        $organizedResults[$postId]['comments'][] = [\n            'idPost' => $row['comment_id'],\n            'postContent' => $row['comment_content'],\n            'idGroup' => $row['comment_idGroup'],\n            'date' => $row['comment_date']\n        ];\n    }\n}\n\nprint_r($organizedResults);