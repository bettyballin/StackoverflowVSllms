function createHtaccessFiles($userFolder) {\n    $htaccessContent = "AuthType Basic\nAuthName \"Restricted Area\"\nAuthUserFile /path/to/{$userFolder}/.htpasswd\nRequire valid-user";\n    file_put_contents("{$userFolder}/.htaccess", $htaccessContent);\n}\n\nfunction createHtpasswdFile($userFolder, $email, $password) {\n    $htpasswdContent = "{$email}:" . crypt($password, base64_encode($password));\n    file_put_contents("{$userFolder}/.htpasswd", $htpasswdContent);\n}