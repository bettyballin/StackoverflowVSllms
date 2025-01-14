// Custom 404 route (application/config/routes.php)\n$pageNotFoundRoute = "ErrorController/not_found";\n\n// Set the default controller to load if the URI contains no data\n$route['default_controller'] = 'Welcome/index';\n\n// Use a wildcard route to catch all non-existent routes\n$route['404_override'] = $pageNotFoundRoute;