class MyModel < ActiveRecord::Base\n  scope :custom_sql, -> {\n    where("sql_query_here")\n  }\nend