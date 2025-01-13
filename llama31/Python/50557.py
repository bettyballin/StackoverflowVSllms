def my_view(request):\n    if request.method == 'POST':\n        form = MyForm(request.POST, request.FILES)\n        if form.is_valid():\n            instance = form.save()\n            # Check if both files came from the same path\n            if instance.file1.name.startswith(instance.folder) and instance.file2.name.startswith(instance.folder):\n                # Files came from the same path\n                pass\n            else:\n                # Files did not come from the same path\n                pass