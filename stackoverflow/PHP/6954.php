/**\n * Sets up the timezone system. $timezone is the timezone. In PunBB, this is\n * called by setup_dates($pun_user['timezone']) in common.php.\n *\n * DON'T USE THIS unless you can't use PHP's DateTime module.\n */\nfunction setup_dates($timezone) {\n    if(function_exists('date_default_timezone_set')) {\n        date_default_timezone_set($timezone) ;\n    } else {\n        putenv('TZ='.$timezone) ;\n    }\n}