$user = new User();\n$user->setName('John Doe');\n$em->persist($user); // Mark the entity for insertion\n$em->flush();        // Execute the SQL INSERT statement