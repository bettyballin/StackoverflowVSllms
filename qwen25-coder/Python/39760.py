from django.shortcuts import redirect\n\ndef my_view(request):\n    # Your view logic here...\n    \n    # Redirect to a URL name\n    return redirect('home')\n\n    # Alternatively, redirect directly to a URL\n    # return redirect('/some-url/')\n\n    # Or redirect with arguments in the URL pattern\n    # return redirect('item_detail', id=5)