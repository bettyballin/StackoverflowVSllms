// Comment.php\nclass Comment extends AppModel {\n    var $name = 'Comment';\n    var $belongsTo = array('Touch');\n}\n\n// Touch.php\nclass Touch extends AppModel {\n    var $name = 'Touch';\n    var $belongsTo = array('Touchtype');\n}\n\n// Touchtype.php\nclass Touchtype extends AppModel {\n    var $name = 'Touchtype';\n}