SELECT * FROM converts \nWHERE email='myemail@googlemail.com' AND status!='1' \nORDER BY floor(unix_timestamp(date)/600) ASC, priority DESC