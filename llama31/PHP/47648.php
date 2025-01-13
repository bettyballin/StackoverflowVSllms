$acl = new Zend_Acl();\n\n$module = new MyAclResource('module');\n$user = new MyAclResource('user');\n$forum = new MyAclResource('forum');\n$gallery = new MyAclResource('gallery');\n\n$module->addParent($user);\n$module->addParent($forum);\n$module->addParent($gallery);\n\n$acl->addResource($module);\n$acl->addResource($user);\n$acl->addResource($forum);\n$acl->addResource($gallery);