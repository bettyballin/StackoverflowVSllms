function is_search_engine_bot() {\n  $user_agent = $_SERVER['HTTP_USER_AGENT'];\n  $bot_agents = array(\n    'Googlebot',\n    'Bingbot',\n    'Slurp', // Yahoo\n    'DuckDuckBot',\n    'YandexBot'\n  );\n  foreach ($bot_agents as $bot_agent) {\n    if (strpos($user_agent, $bot_agent) !== false) {\n      return true;\n    }\n  }\n  return false;\n}