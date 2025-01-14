class BlogController extends Zend_Controller_Action {\n\n    public function(entryAction() {\n        $entryId = $this->_request->getParam('id');\n        \n        // Fetch the blog entry details\n        $blogEntry = $this->_fetchBlogEntry($entryId);\n        \n        // Check if the request is from a mobile device\n        $isMobile = $this->_detectMobileDevice();\n\n        if ($isMobile) {\n            // Render a different view or pass a flag to render comments differently\n            $this->view->entry = $blogEntry;\n            $this->view->loadCommentsOnRequest = true; // Pass a flag for mobile-specific rendering\n            $this->render('entry-mobile'); // Or use a conditional in the same template\n        } else {\n            // Fetch and pass comments to view for web version\n            $comments = $this->_fetchCommentsForEntry($entryId);\n            $this->view->entry = $blogEntry;\n            $this->view->comments = $comments;\n        }\n    }\n\n    private function _detectMobileDevice() {\n        // Simple check using user agent string, consider using more robust library for production\n        return strpos($this->_request->getHeader('User-Agent'), 'iPhone') !== false ||\n               strpos($this->_request->getHeader('User-Agent'), 'Android') !== false;\n    }\n\n    private function _fetchBlogEntry($entryId) {\n        // Logic to fetch blog entry from database or another data source\n        return new Blog_Entry_Model(); // Placeholder for actual entry retrieval logic\n    }\n\n    private function _fetchCommentsForEntry($entryId) {\n        // Logic to fetch comments related to a blog entry\n        $commentList = array(/* ... */); // Mock implementation\n        return $commentList;\n    }\n}