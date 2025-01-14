# forms.py (Ensure you have this form defined for the Post model.)\nfrom django import forms\nfrom .models import Post\n\nclass PostForm(forms.ModelForm):\n    class Meta:\n        model = Post\n        fields = ['title', 'text']