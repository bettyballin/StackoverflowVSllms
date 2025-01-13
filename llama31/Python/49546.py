import re\n\ndef parse_irc_message(message):\n    pattern = re.compile(r"""\n        ^               # start of string\n        :?              # optional colon\n        ([^ ]+)         # sender\n        \s+             # whitespace\n        ([A-Za-z]+)     # command (e.g. PRIVMSG, JOIN, PART, etc.)\n        \s+             # whitespace\n        (?:             # optional parameters\n            ([^:]+)     # parameters (e.g. channel, nickname, etc.)\n            \s+         # whitespace\n        )?\n        :?              # optional colon\n        (.*)            # message or trailing parameters\n        $               # end of string\n    """, re.VERBOSE)\n\n    match = pattern.match(message)\n    if match:\n        result = {\n            "sender": match.group(1),\n            "command": match.group(2),\n            "target": match.group(3),\n            "message": match.group(4)\n        }\n        return result\n    else:\n        return None\n\n# Example usage:\nmessage = ":test!~test@test.com PRIVMSG #channel :Hi!"\nprint(parse_irc_message(message))