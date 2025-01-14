require __DIR__  . '/vendor/autoload.php';\n\nuse PayPal\Rest\ApiContext;\nuse PayPal\Auth\OAuthTokenCredential;\nuse PayPal\Api\RefundRequest;\nuse PayPal\Api\Amount;\n\n// API context is required to set up the environment\n$apiContext = new ApiContext(\n    new OAuthTokenCredential(\n        'YOUR_CLIENT_ID',\n        'YOUR_CLIENT_SECRET'\n    )\n);\n\n$saleId = "SALE_ID_FROM_PAYPAL"; // Replace with actual sale ID\n\n// Create a refund request\n$refundRequest = new RefundRequest();\n$amount = new Amount();\n\n// Set the amount to be refunded (ensure it does not exceed the original payment)\n$amount->setCurrency("USD")->setTotal("10.00");\n$refundRequest->setAmount($amount);\n\ntry {\n    $sale = \PayPal\Api\Sale::get($saleId, $apiContext);\n    $refund = $sale->refund($refundRequest, $apiContext);\n    \n    echo "Refund completed successfully! Refund ID: " . $refund->getId();\n} catch (Exception $ex) {\n    // Handle exception\n    echo "Failed to refund sale. Error: " . $ex->getMessage();\n}