$mapper = new Default_Model_GuestbookMapper();\n$model = new Default_Model_Guestbook();\n\n// Save a new guestbook entry\n$model->setComment('Hello, world!');\n$mapper->save($model);\n\n// Find a guestbook entry by ID\n$model = $mapper->find(1, new Default_Model_Guestbook());\n\n// Fetch all guestbook entries\n$entries = $mapper->fetchAll();