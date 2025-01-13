<?php\n// WHMCS API credentials\n$whmcs_url = 'https://your-whmcs-installation.com';\n$whmcs_username = 'your-whmcs-username';\n$whmcs_password = 'your-whmcs-password';\n\n// Plesk API credentials\n$plesk_url = 'https://your-plesk-installation.com';\n$plesk_username = 'your-plesk-username';\n$plesk_password = 'your-plesk-password';\n\n// Create a new Plesk client\n$client = new SoapClient($plesk_url . '/admin/soap.php?wsdl', array('username' => $plesk_username, 'password' => $plesk_password));\n\n// Create a new WHMCS client\n$whmcs_client = new SoapClient($whmcs_url . '/includes/api.php?wsdl', array('username' => $whmcs_username, 'password' => $whmcs_password));\n\n// Get the customer's hosting plan details from WHMCS\n$customer_plan = $whmcs_client->GetClientProductDetails(array('clientid' => $customer_id, 'productid' => $product_id));\n\n// Create a new Plesk subscription\n$subscription = array(\n    'domain' => $customer_plan['domain'],\n    'plan' => $customer_plan['product'],\n    'owner' => $customer_id,\n);\n$client->createSubscription($subscription);