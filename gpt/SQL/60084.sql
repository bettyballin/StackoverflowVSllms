select * from t1, t2 \nwhere t1.country = 'US' \n  and t2.country = 'US' \n  and t1.id = t2.id;