def another_view(request):\n    # Access the cookies sent by the client\n    unique_id = request.cookies.get('uniqueid')\n    nickname = request.cookies.get('nickname')\n\n    # Proceed with your logic using these values