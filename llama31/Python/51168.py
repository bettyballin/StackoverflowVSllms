import re\n\ninput_string = "Hello, my website is http://example.com and you can also visit http://example2.com for more info."\nurls = re.findall(r'http://[a-zA-Z0-9\/\.]*', input_string)\n\nnon_url_text = re.sub(r'http://[a-zA-Z0-9\/\.]*', '', input_string)\n\nprint(non_url_text)