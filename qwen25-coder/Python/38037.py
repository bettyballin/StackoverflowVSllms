# views.py\nfrom django.core.files.storage import default_storage\nfrom django.core.files.base import ContentFile\nimport os\n\ndef upload_resume(request):\n    if request.method == 'POST' and request.FILES['resume']:\n        resume_file = request.FILES['resume']\n        # Save the file to media directory or another designated path\n        path = default_storage.save('resumes/' + resume_file.name, ContentFile(resume_file.read()))\n        print(f"File saved at: {path}")\n        return HttpResponse("Resume uploaded successfully.")\n\n# models.py (store the path)\nfrom django.db import models\n\nclass Candidate(models.Model):\n    name = models.CharField(max_length=100)\n    resume_path = models.CharField(max_length=255)\n\n# To retrieve the file content later\nwith open(os.path.join(settings.MEDIA_ROOT, candidate.resume_path), 'rb') as f:\n    resume_content = f.read()