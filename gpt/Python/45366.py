from pylons import request, tmpl_context as c\nfrom pylons.controllers.util import abort, redirect_to\nfrom myproject.lib.base import BaseController, render\nfrom formencode import htmlfill\nfrom formencode.validators import Invalid\n\nclass MyController(BaseController):\n\n    def create(self):\n        return render('/myform.mako')\n\n    def submit(self):\n        schema = MyFormSchema()\n        try:\n            form_result = schema.to_python(request.params)\n            # Process the validated data (form_result)\n            # Save to database or perform other actions\n            redirect_to('/success')\n        except Invalid as e:\n            # If validation fails, re-render the form with errors\n            html = render('/myform.mako')\n            return htmlfill.render(html, defaults=request.params, errors=e.unpack_errors())