select \n    u.username, \n    u.email, \n    m.title, \n    m.text \n       -- ... etc\nfrom microblog m\n     inner join user u on m.user_id = u.id\nwhere  m.user_id = {$user_id} \n    or m.user_id in (select \n                         following_id \n                     from relations r \n                     where follower_id = {$user_id}\n                    );