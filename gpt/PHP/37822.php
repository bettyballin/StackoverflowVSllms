// Install APCu\nsudo apt-get install php-apcu\n\n// Enable APCu in php.ini\nextension=apcu.so\n\n// Example usage in PHP\napcu_store('key', 'value');\n$value = apcu_fetch('key');