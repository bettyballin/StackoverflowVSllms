<?php\n// Ensure this file is accessible by the payment gateway at the specified webhook URL\n\n// Include MediaWiki setup to access its functions and classes\nrequire_once 'path/to/your/wiki/includes/WebStart.php';\n\nuse Stripe\Event;\nuse Stripe\Webhook;\n\n$endpoint_secret = 'whsec_yourStripeWebhookSecret';\n$input = @file_get_contents("php://input");\n$sig_header = $_SERVER['HTTP_STRIPE_SIGNATURE'];\n\ntry {\n    $event = Webhook::constructEvent(\n        $input, $sig_header, $endpoint_secret\n    );\n} catch (\UnexpectedValueException|InvalidArgumentException $e) {\n    // Invalid payload\n    http_response_code(400); // Bad request\n    exit();\n}\n\nswitch ($event->type) {\n    case 'customer.subscription.created':\n    case 'invoice.paid':\n        handleSubscription($event->data['object']);\n        break;\n    default:\n        // Ignore event types you don't need to handle\n        http_response_code(200); // OK\n        exit();\n}\n\nfunction handleSubscription($subscription) {\n    global $wgUser;\n\n    // Fetch the customer's email or unique ID from the subscription data\n    $customerEmail = $subscription->customer_email;\n    \n    // Query MediaWiki user database to find user by email\n    $dbw = wfGetDB(DB_MASTER);\n    $row = $dbw->selectRow('user', '*', ['user_email' => $customerEmail]);\n\n    if ($row) {\n        $userId = $row->user_id;\n        // Assign a special group (e.g., 'subscriber') to this user\n        User::newFromId($userId)->addGroup('subscriber');\n    }\n}\n\nhttp_response_code(200); // OK