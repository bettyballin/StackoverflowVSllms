from pylons import request, response\nfrom pylons.controllers.util import redirect\nfrom formencode import Invalid\nfrom yourapp.forms import UserSchema\n\nclass UserController(BaseController):\n    def create(self):\n        schema = UserSchema()\n        try:\n            data = schema.to_python(request.params)\n        except Invalid, e:\n            return render('/create.mako', {'errors': e.unpack_errors()})\n        \n        # create user logic here\n        return redirect('/users')