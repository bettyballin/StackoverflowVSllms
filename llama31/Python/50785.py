raw_sql = "SELECT * FROM myapp_mymodel WHERE name = %s"\nqs = MyModel.objects.raw(raw_sql, params=['foo'])