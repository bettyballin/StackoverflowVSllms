from rest_framework import serializers\nfrom myapp.models import MyModel\n\nclass MyModelSerializer(serializers.ModelSerializer):\n    class Meta:\n        model = MyModel\n        fields = '__all__'