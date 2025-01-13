from django.forms.widgets import TextInput\nfrom django.utils.safestring import mark_safe\n\nclass TextInputWithHint(TextInput):\n    def render(self, name, value, attrs=None, renderer=None):\n        if attrs is None:\n            attrs = {}\n        if 'id' not in attrs:\n            attrs['id'] = self.build_attrs(self.attrs, name=name).get('id', None)\n        \n        res = super(TextInputWithHint, self).render(name, value, attrs, renderer)\n        res += mark_safe(u'<script type="text/javascript">alert("%s")</script>' % attrs['id'])\n        return res