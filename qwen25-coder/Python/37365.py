# views.py\n\ndef your_view(request):\n    if request.method == 'POST':\n        form = YourForm(request.POST, request=request)  # Pass the request object here\n        if form.is_valid():\n            # Process the data\n            pass\n    else:\n        form = YourForm()\n    return render(request, 'your_template.html', {'form': form})