class PaypalNotificationsController extends AppController {\n    var $name = 'PaypalNotifications';\n\n    function beforeFilter() {\n        parent::beforeFilter();\n        $this->Auth->allow('process');\n    }\n\n    // Your other methods\n}