import cProfile\nimport pstats\nfrom io import StringIO\n\nclass ProfilerMiddleware:\n    def __init__(self, app):\n        self.app = app\n\n    def __call__(self, environ, start_response):\n        profiler = cProfile.Profile()\n        profiler.enable()\n\n        # The actual WSGI application call\n        response_iter = self.app(environ, start_response)\n\n        profiler.disable()\n        output = StringIO()\n        stats = pstats.Stats(profiler, stream=output)\n        stats.sort_stats('cumulative').print_stats(.1)  # Adjust the threshold as needed\n\n        print(output.getvalue())  # This prints to stderr. Redirect as necessary\n        return response_iter\n\ndef application(environ, start_response):\n    # Your WSGI app logic goes here\n    status = '200 OK'\n    output = b'Hello World!'\n    \n    response_headers = [('Content-type', 'text/plain'),\n                        ('Content-Length', str(len(output)))]\n    start_response(status, response_headers)\n\n    return [output]\n\n# Wrap the application with the profiler middleware\napplication = ProfilerMiddleware(application)