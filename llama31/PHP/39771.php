$token = bin2hex(random_bytes(16));\nheader('Location: http://your-confirmation-page.com?token=' . $token);