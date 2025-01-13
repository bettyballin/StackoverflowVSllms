// PHP example using the SharePoint STS\n$stsUrl = 'https://your-sharepoint-site.sharepoint.com/_sts/';\n$tokenEndpoint = $stsUrl . 'issue/wstrust/mixed/username';\n\n// Redirect user to SharePoint STS for authentication\nheader('Location: ' . $tokenEndpoint);\nexit;\n\n// Handle the redirect from SharePoint STS and validate the token\nif (isset($_GET['wa']) && $_GET['wa'] == 'wsignin1.0') {\n    // Validate the token and extract the user's identity\n    $token = $_POST['wresult'];\n    // ...\n}