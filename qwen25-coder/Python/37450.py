# Example using Django REST Framework\nfrom django.http import JsonResponse\nfrom rest_framework.views import APIView\n\nclass HelloWorld(APIView):\n    def get(self, request, format=None):\n        return JsonResponse({"message": "Hello, world!"})