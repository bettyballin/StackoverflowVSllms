use Raven_Client;\n\n$client = new Raven_Client('https://your-sentry-instance.com/1');\n\ntry {\n    // Your code here\n} catch (Exception $e) {\n    $client->captureException($e);\n}