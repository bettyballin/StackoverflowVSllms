# myapp/forms.py\nfrom django import forms\nfrom myapp.models import MyModel\n\nclass MyModelForm(forms.ModelForm):\n    class Meta:\n        model = MyModel\n\n    def clean_nzb(self):\n        # validation logic for the nzb field goes here\n        # you can raise forms.ValidationError if the validation fails\n        pass