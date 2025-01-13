$batchSize = 1000; // Number of users to process in each batch\n   $offset = 0;\n\n   while (true) {\n       $users = getUsers($offset, $batchSize); // Fetch a batch of users from the database\n       if (empty($users)) {\n           break; // No more users to process\n       }\n\n       foreach ($users as $user) {\n           processUserSearch($user); // Process the saved search for each user\n       }\n\n       $offset += $batchSize;\n   }