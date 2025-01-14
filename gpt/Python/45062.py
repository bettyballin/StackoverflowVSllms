from django_raw_queryset import RawQuerySet\n   from myapp.models import MyModel\n\n   # Define your raw SQL query\n   raw_query = '''\n   SELECT id, name, created_at\n   FROM myapp_mymodel\n   WHERE some_field = %s\n   ORDER BY created_at DESC\n   '''\n\n   # Execute the query and map the results to the Django model\n   queryset = RawQuerySet(MyModel, raw_query, [some_value])\n\n   # Iterate through the results as if it were a normal queryset\n   for obj in queryset:\n       print(obj.id, obj.name, obj.created_at)