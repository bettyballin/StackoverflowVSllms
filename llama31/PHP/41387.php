$cookieString = '...'; // your cookie string here\n\n$sessionId = preg_replace('/.*sessionid=([^,;]*).*/', '$1', $cookieString);\n$cadata = preg_replace('/.*cadata="([^"]*)".*/', '$1', $cookieString);