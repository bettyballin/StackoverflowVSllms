#!/usr/bin/php\nfunction set_cookie($cookiename,$cookievalue,$cookietime){\n   echo 'set-cookie: '.$cookiename.'="'.$cookievalue.'"; max-age="'.$cookietime.'";'."\n";  \n}