$actionTable = new Application_Model_DbTable_Actions();\n$actionsWithUsers = $actionTable->fetchAllActionsWithUserDetails();\n\nforeach ($actionsWithUsers as $action) {\n    echo $action->name; // Access action details\n    echo ' - Created by: ' . $action->user_name; // Access joined user details\n}