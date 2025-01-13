<?php\n\nclass YourNamespace_HelloWorld_IndexController extends Mage_Core_Controller_Front_Action\n{\n    public function indexAction()\n    {\n        echo 'Hello World';\n    }\n\n    public function showRowAction()\n    {\n        $articleId = 10;\n        $article = Mage::getModel('helloworld/article')->load($articleId);\n        if ($article->getId()) {\n            echo 'ID: ' . $article->getId() . '<br>';\n            echo 'Title: ' . $article->getTitle() . '<br>';\n            echo 'Content: ' . $article->getContent() . '<br>';\n        } else {\n            echo 'Article not found';\n        }\n    }\n}