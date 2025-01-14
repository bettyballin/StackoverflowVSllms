require 'vendor/autoload.php';\n\nuse \Firebase\JWT\JWT;\n\n$key = "your-256-bit-secret";\n$jwt = $_GET['token']; // Assuming token is passed via GET (for demo purposes)\n\ntry {\n    $decoded = JWT::decode($jwt, $key, array('HS256'));\n\n    // Access data stored in the token\n    print_r((array) $decoded);\n} catch (\Firebase\JWT\ExpiredException $e) {\n    echo "Token expired";\n} catch (Exception $e) {\n    echo "Invalid JWT Token";\n}