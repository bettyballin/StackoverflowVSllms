require 'vendor/autoload.php';\n\nuse PayPal\Rest\ApiContext;\nuse PayPal\Auth\OAuthTokenCredential;\n\n$apiContext = new ApiContext(\n    new OAuthTokenCredential(\n        'YourClientID',     // ClientID\n        'YourClientSecret'  // ClientSecret\n    )\n);\n\n$apiContext->setConfig([\n    'mode' => 'sandbox', // or 'live' for production\n]);\n\n// Create payment, execute payment, etc.