class ProductForm(ModelForm):\n    long_desc = forms.CharField(widget=forms.Textarea(attrs={'class': 'my-textarea'}))\n    short_desc = forms.CharField(widget=forms.Textarea(attrs={'class': 'my-textarea'}))\n    \n    class Meta:\n        model = Product