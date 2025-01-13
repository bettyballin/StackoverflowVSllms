from django import forms\n\nchoices = ((True, 'Yes'), (False, 'No'))\n\nclass EmailEditForm(forms.ModelForm):\n    to_send_form = forms.TypedChoiceField(choices=choices, widget=forms.RadioSelect, coerce='bool')\n\n    class Meta:\n        model = EmailParticipant\n        fields = ('to_send_email', 'to_send_form')