// Load environment variables using a library like vlucas/phpdotenv\n    require 'vendor/autoload.php';\n    $dotenv = Dotenv\Dotenv::createImmutable(__DIR__);\n    $dotenv->load();\n\n    $awsAccessKeyId = getenv('AWS_ACCESS_KEY_ID');\n    $awsSecretAccessKey = getenv('AWS_SECRET_ACCESS_KEY');