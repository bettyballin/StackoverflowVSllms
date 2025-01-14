from rest_framework import viewsets\nfrom myapp.models import MyModel\nfrom .serializers import MyModelSerializer\n\nclass MyModelViewSet(viewsets.ModelViewSet):\n    queryset = MyModel.objects.all()\n    serializer_class = MyModelSerializer\n    \n    # Add authentication and permission classes here\n    from rest_framework.authentication import SessionAuthentication, BasicAuthentication\n    from rest_framework.permissions import IsAuthenticated\n\n    authentication_classes = [SessionAuthentication, BasicAuthentication]\n    permission_classes = [IsAuthenticated]