use Zend\Http\Header\SetCookie;\n\n// Set language cookie\n$cookie = new SetCookie('lang', $userLang, time() + 3600 * 24 * 30); // 30 days\n$cookie->setHttpOnly(true);\n$cookie->setSecure(true);