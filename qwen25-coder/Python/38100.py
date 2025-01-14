from django.shortcuts import render\nfrom .forms import MyForm\n\ndef my_view(request):\n    if request.method == 'POST':\n        form = MyForm(request.POST)\n        if form.is_valid():\n            # Process the data in form.cleaned_data\n            cleaned_integer = form.cleaned_data['my_integer_field']\n            return JsonResponse({'message': f"Integer received: {cleaned_integer}"})\n        else:\n            return render(request, 'template_with_form.html', {'form': form})\n    else:\n        form = MyForm()\n        return render(request, 'template_with_form.html', {'form': form})