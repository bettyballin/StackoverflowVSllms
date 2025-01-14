# views.py\nfrom rest_framework import viewsets\nfrom .models import SecurityGuardLocation  # Example model\nfrom .serializers import SecurityGuardLocationSerializer  # Import your serializer\n\nclass SecurityGuardLocationViewSet(viewsets.ModelViewSet):\n    queryset = SecurityGuardLocation.objects.all()\n    serializer_class = SecurityGuardLocationSerializer