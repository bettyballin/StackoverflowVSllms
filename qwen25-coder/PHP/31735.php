require __DIR__ . '/vendor/autoload.php';\n\n   use \Delight\Auth\Auth;\n\n   $auth = new Auth($db); // Assume $db is your PDO or mysqli database object\n\n   try {\n       if ($auth->login('user@example.com', 'securepassword')) {\n           echo 'Successfully logged in!';\n       } else {\n           echo 'Login failed: No such user!';\n       }\n   } catch (\Delight\Auth\InvalidEmailException $e) {\n       die('Wrong email address!');\n   } catch (\Delight\Auth\InvalidPasswordException $e) {\n       die('Wrong password!');\n   } catch (\Delight\Auth\UserAlreadyExistsException $e) {\n       die('User already exists!');\n   } catch (\Delight\Auth\TooManyRequestsException $e) {\n       die('Too many requests');\n   }\n\n   // For registration\n   try {\n       $userId = $auth->register('user@example.com', 'securepassword');\n\n       echo 'Successfully registered!';\n   }\n   catch (\Delight\Auth\InvalidEmailException $e) {\n       die('Invalid email address!');\n   }\n   catch (\Delight\Auth\DuplicateUsernameException $e) {\n       die('User already exists with that username!');\n   }\n   catch (\Delight\Auth\DuplicateEmailException $e) {\n       die('User already exists with that email address!');\n   }