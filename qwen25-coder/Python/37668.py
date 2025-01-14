from pylons import request, session, redirect, url\nfrom myapp.lib.base import BaseController, render\nfrom myapp.forms.registration_form import RegistrationForm\n\nclass UserController(BaseController):\n    def register(self):\n        c.form_errors = {}\n        c.values = {'username': '', 'email': ''}\n        \n        if request.method == 'POST':\n            form = RegistrationForm()\n            \n            try:\n                cleaned_data = form.to_python(request.POST)\n                session['user'] = cleaned_data  # Save user data in session or database\n                redirect(url(controller='user', action='success'))\n            except Invalid as e:\n                c.form_errors.update(e.unpack_errors())\n        \n        return render('/register.mako')