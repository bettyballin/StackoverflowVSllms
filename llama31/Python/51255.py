from myapp.models import MyModel\n\n# Create a new instance\nmy_object = MyModel(name='John Doe', email='john.doe@example.com')\nmy_object.save()\n\n# Query the database\nobjects = MyModel.objects.filter(name='John Doe')