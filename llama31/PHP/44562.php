// Assuming you've defined your environments in index.php\nif (ENVIRONMENT === 'production') {\n    $this->config->load('config_production', true);\n} elseif (ENVIRONMENT === 'development') {\n    $this->config->load('config_development', true);\n}