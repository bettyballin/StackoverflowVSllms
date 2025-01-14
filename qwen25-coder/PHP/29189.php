// Application/config/routes.php\n\n// Default route if no specific URI is provided\n$route['default_controller'] = 'Survey/index';\n\n// Route for a new survey taker\n$route['survey/(:num)'] = 'Survey/take_survey/$1';\n\n// Route for an existing survey session\n$route['survey/(:any)/(:num)'] = 'Survey/survey_session/$2/$3';