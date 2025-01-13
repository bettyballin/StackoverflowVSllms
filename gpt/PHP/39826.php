<?php\nrequire 'vendor/autoload.php';\n\nuse Zend\Permissions\Acl\Acl;\nuse Zend\Permissions\Acl\Role\GenericRole as Role;\nuse Zend\Permissions\Acl\Resource\GenericResource as Resource;\n\n// Create ACL instance\n$acl = new Acl();\n\n// Define roles\n$acl->addRole(new Role('guest'));\n$acl->addRole(new Role('registered'));\n\n// Define resources\n$resources = [\n    'module' => [],\n    'user' => [],\n    'forum' => [],\n    'gallery' => [],\n    'profile' => [],\n    'topic' => [],\n    'photo' => [],\n    'post' => [],\n];\n\nforeach ($resources as $resource => $_) {\n    $acl->addResource(new Resource($resource));\n}\n\n// Define generic permissions\n$acl->allow('guest', 'module', 'read');\n$acl->deny('guest', 'photo', 'read');\n$acl->allow('registered', 'profile', 'edit');\n\n// Function to apply generic permissions to instances\nfunction applyGenericPermissions($acl, $genericResource, $instanceResource) {\n    $roles = $acl->getRoles();\n    foreach ($roles as $role) {\n        foreach ($acl->getResources() as $resource) {\n            if ($acl->hasResource($resource)) {\n                if ($acl->isAllowed($role, $genericResource, 'read')) {\n                    $acl->allow($role, $instanceResource, 'read');\n                }\n                if ($acl->isDenied($role, $genericResource, 'read')) {\n                    $acl->deny($role, $instanceResource, 'read');\n                }\n                if ($acl->isAllowed($role, $genericResource, 'edit')) {\n                    $acl->allow($role, $instanceResource, 'edit');\n                }\n                if ($acl->isDenied($role, $genericResource, 'edit')) {\n                    $acl->deny($role, $instanceResource, 'edit');\n                }\n            }\n        }\n    }\n}\n\n// Define instance resources and apply generic permissions\n$instanceResources = [\n    'module_1' => 'module',\n    'user1' => 'user',\n    'user2' => 'user',\n    'user3' => 'user',\n    'forum' => 'forum',\n    'gallery1' => 'gallery',\n    'gallery2' => 'gallery',\n    'profile1' => 'profile',\n    'profile2' => 'profile',\n    'profile3' => 'profile',\n    'sub1' => 'topic',\n    'sub2' => 'topic',\n    'post1' => 'post',\n    'post2' => 'post',\n    'post3' => 'post',\n    'photo1' => 'photo',\n    'photo2' => 'photo',\n    'photo3' => 'photo',\n    'photo4' => 'photo',\n];\n\nforeach ($instanceResources as $instance => $generic) {\n    $acl->addResource(new Resource($instance));\n    applyGenericPermissions($acl, $generic, $instance);\n}\n\n// Example: Check permissions\necho $acl->isAllowed('guest', 'module_1', 'read') ? 'allowed' : 'denied'; // Output: allowed\necho $acl->isAllowed('guest', 'photo1', 'read') ? 'allowed' : 'denied'; // Output: denied\n?>