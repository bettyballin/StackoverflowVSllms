from django.http import HttpResponse\nfrom .models import User, Idea\n\ndef your_view(request):\n    if "login" in request.session:\n        t = request.POST.get('title', '')\n        d = request.POST.get('description', '')\n        fid = request.session["login"]\n        fuser = User.objects.get(id=fid)\n        i = Idea(user=fuser, title=t, description=d, num_votes=1)\n        i.save()\n        return HttpResponse("true", content_type="text/plain")\n    else:\n        return HttpResponse("false", content_type="text/plain")