class YourController extends Zend_Controller_Action\n{\n    protected $_store = null;\n\n    public function indexAction()\n    {\n        $this->_loadStore();\n        // Rest of your code...\n    }\n\n    public function getdataAction()\n    {\n        $this->_helper->layout->disableLayout(); // Will not load the layout\n        $this->_helper->viewRenderer->setNoRender(); //Will not render view\n\n        $this->_loadStore();\n\n        if ($this->_store !== null) {\n            $jsonResponse = json_encode($this->_store);\n            $this->getResponse()\n                 ->setHeader('Content-Type', 'application/json')\n                 ->setBody($jsonResponse);\n        } else {\n            // Handle the case where store is not found\n            $this->getResponse()->setHttpResponseCode(404)->setBody(json_encode(['error' => 'Store not found']));\n        }\n    }\n\n    protected function _loadStore()\n    {\n        if ($this->_store === null) {\n            $cacheKey = $this->_getCacheKey();\n            $cache = Zend_Registry::get('cache');\n\n            if (($storeData = $cache->load($cacheKey)) !== false) {\n                $this->_store = $storeData;\n            } else {\n                $storeid = $this->getStoreId();\n\n                if (!$storeid) {\n                    return null; // Or handle the error properly\n                }\n\n                $store = $this->_helper->loadModel('stores');\n                $store->getByPrimary($storeid);\n                $this->_store = $store->toArray(); // Assuming you have a method toArray() in your model\n\n                // Store data in cache for future requests within a certain time limit (e.g., 300 seconds)\n                $cache->save($this->_store, $cacheKey, [], 300);\n            }\n        }\n\n        return $this->_store;\n    }\n\n    protected function _getCacheKey()\n    {\n        // Returns a unique cache key for each store based on the store ID\n        return 'store_' . $this->getStoreId();\n    }\n\n    protected function getStoreId()\n    {\n        // Implement your logic to fetch/store the store ID here\n    }\n}