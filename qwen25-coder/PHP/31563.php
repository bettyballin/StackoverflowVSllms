// Example of creating a JWT token with PHP\n   $token = \Firebase\JWT\JWT::encode(['userPreferences' => ['theme' => 'dark']], $secretKey, 'HS256');