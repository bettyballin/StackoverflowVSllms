require_once 'Zend/Openid/Consumer.php';\n\nclass MyAuthController extends Zend_Controller_Action {\n    public function loginAction() {\n        $openid = new Zend_OpenId_Consumer();\n\n        // For Google and Yahoo, use their direct identity URLs\n        $providerEndpoints = [\n            'google' => 'https://www.google.com/accounts/o8/id',\n            'yahoo' => 'https://me.yahoo.com/'\n        ];\n\n        // Assume we're coming from a form with a provider selection\n        $provider = $this->_request->getParam('provider');\n        if (isset($providerEndpoints[$provider])) {\n            $endpoint = $providerEndpoints[$provider];\n            $returnToUrl = $this->view->url(['controller' => 'auth', 'action' => 'verify'], null, true);\n\n            // Perform authentication\n            if ($openid->login($endpoint, $returnToUrl)) {\n                echo "Authentication in progress...";\n            } else {\n                echo "Authentication failed.";\n            }\n        } else {\n            echo "Invalid provider.";\n        }\n    }\n\n    public function verifyAction() {\n        $openid = new Zend_OpenId_Consumer();\n\n        if ($openid->verify($_GET, $id)) {\n            // Authentication successful\n            echo "Logged in as " . htmlspecialchars($id);\n        } else {\n            // Authentication failed\n            echo "Authentication error";\n        }\n    }\n}