select col2\nfrom mytable\ngroup by col2 having count(distinct col1) > 1;