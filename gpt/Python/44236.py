from flask import request, abort\n\n    @app.before_request\n    def block_bad_bots():\n        user_agent = request.headers.get('User-Agent')\n        if 'Googlebot' not in user_agent and 'Bingbot' not in user_agent and 'Mozilla' not in user_agent:\n            abort(403)