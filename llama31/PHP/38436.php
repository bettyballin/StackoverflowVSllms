$smarty->registerPlugin('modifier', 'base_url', 'smartyBaseUrl');\n\nfunction smartyBaseUrl($url) {\n    return 'http://your-base-url.com/' . $url;\n}