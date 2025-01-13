class LanguageController extends Zend_Controller_Action\n{\n    public function changeLanguageAction()\n    {\n        $language = $this->_getParam('lang'); // assuming `lang` is the parameter name\n        if (in_array($language, ['en', 'fr', 'es'])) { // Validate against allowed languages\n            setcookie('user_language', $language, time() + (86400 * 30), "/"); // Set cookie for 30 days\n            $_SESSION['user_language'] = $language; // Set session\n        }\n        // Redirect back to the previous page or homepage\n        $this->_redirect('/');\n    }\n}\n\n// Retrieve language in any controller\nclass SomeController extends Zend_Controller_Action\n{\n    public function init()\n    {\n        if (isset($_COOKIE['user_language'])) {\n            $user_language = $_COOKIE['user_language'];\n        } elseif (isset($_SESSION['user_language'])) {\n            $user_language = $_SESSION['user_language'];\n        } else {\n            $user_language = 'default_language';\n        }\n        // Set the language in the application\n        Zend_Registry::set('Zend_Locale', $user_language);\n    }\n}