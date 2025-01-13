from rest_framework import status\nfrom rest_framework.response import Response\nfrom rest_framework.views import APIView\nfrom .models import MyModel\nfrom .serializers import MyModelSerializer\n\nclass MyModelView(APIView):\n    def get(self, request):\n        mymodels = MyModel.objects.all()\n        serializer = MyModelSerializer(mymodels, many=True)\n        return Response(serializer.data)