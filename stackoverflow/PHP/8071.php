// UserManager.php:\n\nclass UserManager\n{\n    function getUsers()\n    {\n        $pdo = new PDO(...);\n        $stmt = $pdo->prepare('\n            SELECT       u.userId as id,\n                         u.userName,\n                         g.groupId,\n                         g.groupName\n            FROM         user u\n            INNER JOIN   group g\n            ON           u.groupId = g.groupId\n            ORDER BY     u.userName, g.groupName\n        ');\n        // iterate over result and prepare return value\n    }\n\n    function getUser($id) {\n        // db code here\n    }\n}\n\n// index.php:\nrequire_once("UserManager.php");\n$um = new UserManager;\n$users = $um->getUsers();\nforeach ($users as $user) echo $user['name'];