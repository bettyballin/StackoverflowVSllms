execute :mvddl := 'create materialized view MV_FOO_BAR' ||\n                  ' build immediate' ||\n                  ' refresh fast on commit' ||\n                  ' as ' ||\n                  ' select * from ...';