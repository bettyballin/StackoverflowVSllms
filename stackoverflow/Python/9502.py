class ItemForm(forms.ModelForm):\n    class Meta:\n        model = Item\n\n    def clean_description(self):\n        if not self.cleaned_data['description'].strip():\n            raise forms.ValidationError('Your error message here')