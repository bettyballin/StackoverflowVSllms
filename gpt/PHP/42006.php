// application/helpers/custom_helper.php\n   if (!function_exists('render_user_profile')) {\n       function render_user_profile($user) {\n           $CI =& get_instance();\n           return $CI->load->view('partials/user_profile', ['user' => $user], true);\n       }\n   }