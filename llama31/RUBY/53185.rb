def foo\n  Rails.cache.fetch("report_#{id}_foo", expires_in: 1.hour) do\n    expensive_sql_query_result\n  end\nend