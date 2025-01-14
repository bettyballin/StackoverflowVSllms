from django.http import JsonResponse\nfrom django.views.decorators.csrf import csrf_exempt\nfrom .models import Comment\n\n@csrf_exempt\ndef add_comment(request):\n    if request.method == 'POST':\n        comment_text = request.POST.get('comment')\n        post_id = request.POST.get('post_id')\n        # Assuming you have a Comment model with a post_id and text fields\n        comment = Comment.objects.create(post_id=post_id, text=comment_text)\n        return JsonResponse({'comment': comment.text, 'status': 'success'})\n    return JsonResponse({'status': 'fail'})