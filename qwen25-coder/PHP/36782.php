class Zend_View_Helper_RenderCategories extends Zend_View_Helper_Abstract\n   {\n       public function renderCategories()\n       {\n           $categories = $this->view->categories;\n           $html = '<ul>';\n           foreach ($categories as $category) {\n               $html .= '<li>' . htmlspecialchars($category->name) . '</li>'; // Assume 'name' is a column in your categories table\n           }\n           $html .= '</ul>';\n           return $html;\n       }\n   }