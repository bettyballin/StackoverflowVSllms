select * from t\n order by to_number(regexp_substr(a,'^[0-9]+')),\n          to_number(regexp_substr(a,'[0-9]+$')),\n          a;