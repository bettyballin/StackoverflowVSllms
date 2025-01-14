from threading import local\n\n_thread_locals = local()\n\ndef get_current_user():\n    return getattr(_thread_locals, 'user', None)\n\ndef get_session_data(key):\n    user = get_current_user()\n    if hasattr(user, 'session_data'):\n        return user.session_data.get(key, None)\n    return None\n\nclass SessionMiddleware:\n    def __init__(self, get_response):\n        self.get_response = get_response\n\n    def __call__(self, request):\n        _thread_locals.user = request.user\n        if not hasattr(request.user, 'session_data'):\n            request.user.session_data = {}\n        request.user.session_data['your_key'] = request.session.get('your_session_key')\n        \n        response = self.get_response(request)\n        return response