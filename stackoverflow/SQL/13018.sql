select \n    g.name, u.username,\n    (select url from pictures p where p.gallery_id = g.gallery_id \n     order by rand() limit 1) as url\nfrom galleries g\nleft join users u on g.user_id = u.id\nwhere g.active = 1