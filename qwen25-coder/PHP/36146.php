try {\n    $db = parent::getConnection();\n    // ... other code ...\n} catch (Exception $e) {\n    throw $e;\n} finally {\n    parent::closeConnection($db);\n}