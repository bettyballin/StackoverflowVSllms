UPDATE ValTable\nSET val = 2.124\nWHERE str_key = (SELECT str_key FROM StrTable WHERE string = 'a')\nAND other_key = 1;