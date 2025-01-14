require 'vendor/autoload.php';\n\n\Stripe\Stripe::setApiKey('your_stripe_secret_key');\n\n// Create a new customer\n$customer = \Stripe\Customer::create([\n    'email' => 'customer@example.com',\n    'source' => 'tok_visa', // obtained with Stripe.js\n]);\n\n// Subscribe the customer to a plan\n$subscription = \Stripe\Subscription::create([\n    'customer' => $customer->id,\n    'items' => [\n        [\n            'plan' => 'plan_id',\n        ],\n    ],\n]);\n\necho "Subscription created with ID: " . $subscription->id;