class Decorator {\n    public static $formDecorators = array(\n        'FormElements',\n        'HtmlTag' => array('tag' => 'table', 'class' => 'zend_form'),\n        'Form',\n    );\n\n    public static $elementDecorators = array(\n        'UiWidgetElement', // Ensure this is included to render DatePicker\n        'Errors',\n        array(array('data' => 'HtmlTag'), array('tag' => 'td')),\n        array('Label', array('tag' => 'td')),\n        array(array('row' => 'HtmlTag'), array('tag' => 'tr')),\n    );\n\n    public static $buttonDecorators = array(\n        'UiWidgetElement', // Ensure this is included if your submit button requires jQuery enhancement\n        array(array('data' => 'HtmlTag'), array('tag' => 'td')),\n        array(array('row' => 'HtmlTag'), array('tag' => 'tr')),\n    );\n}