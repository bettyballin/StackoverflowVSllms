// Example with additional flags (not directly usable without setcookie but for understanding)\nheader("Set-Cookie: $cookieName=$cookieValue; expires=" . gmdate("D, d-M-Y H:i:s", $expirationTime) . " GMT; Path=/; Secure; HttpOnly");