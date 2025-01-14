class Categories extends CI_Controller {\n    public function __construct() {\n        parent::__construct();\n        $this->load->library('upload');\n        $this->load->model('categories_m');\n        $this->load->model('products_m');\n        $this->load->model('pages_m');\n        $this->load->model('backoffice/backofficecategories_m');\n    }\n\n    public function categories() {\n        $data = [];\n        $action = $this->uri->segment(3);\n        \n        // Shared initialization logic\n        $data['body'] = $this->load->view('backoffice/categories/navigation_v', '', TRUE);\n        $data['cat_tree'] = $this->categories_m->getCategoryTree();\n        $data['page_list'] = $this->pages_m->getPageList();\n        $data['category_dropdown'] = $this->load->view('backoffice/categories/category_dropdown_v', $data, TRUE);\n\n        // Handle each action\n        switch ($action) {\n            case 'delete':\n                $this->_handleDelete($data);\n                break;\n            case 'preview':\n                $this->_handlePreview($data);\n                break;\n            // Add more cases as necessary\n            default:\n                $this->load->library('table');\n                $data['body'] .= $this->load->view('backoffice/categories/categories_v', $data, TRUE);\n                break;\n        }\n\n        // Load the main template with accumulated data\n        $this->load->view('backoffice/template_v', $data);\n    }\n\n    private function _handleDelete(&$data) {\n        $categoryTreeID = $this->sitewide_m->checkURLParam($this->uri->segment(4), 'CategoryTree');\n\n        if (isset($_POST['delete'])) {\n            $this->backofficecategories_m->deleteCategory($categoryTreeID);\n            $data['body'] .= '<span class="error">Category Deleted.</span>';\n        } else {\n            $cat_details = $this->categories_m->getCategoryDetails('', $categoryTreeID)->row();\n            $data['parent_category'] = $this->categories_m->getParentCategory($categoryTreeID);\n            $data['products_to_reassign'] = $this->products_m->getProductsInCategory('', $categoryTreeID);\n\n            // Pass data to view\n            $data['body'] .= $this->load->view('backoffice/categories/delete_v', [\n                'cat_details' => $cat_details,\n                'parent_category' => $data['parent_category'],\n                'products_to_reassign' => $data['products_to_reassign']\n            ], TRUE);\n        }\n    }\n\n    private function _handlePreview(&$data) {\n        if ($this->uri->segment(4)) \n            $categoryTreeID = $this->sitewide_m->checkURLParam($this->uri->segment(4), 'CategoryTree');\n        \n        // Fetch category details\n        $cat_details = $this->categories_m->getCategoryDetails(NULL, $categoryTreeID)->row();\n        \n        if ($cat_details) {\n            $data['categoryName'] = $cat_details->Name;\n            $data['categoryID'] = $cat_details->ID;\n            \n            // Load view with data\n            $data['body'] .= $this->load->view('backoffice/categories/preview_v', [\n                'categoryName' => $data['categoryName'],\n                'categoryID' => $data['categoryID']\n            ], TRUE);\n        }\n    }\n\n    // Add more private methods for different actions as needed\n}