class Company_SpecialCheckout_ImageController extends Mage_Core_Controller_Front_Action {\n    public function uploadAction() {\n        // Load layout to display the form for uploading images\n        $this->loadLayout();\n        $this->getLayout()->getBlock('root')->setTemplate('page/1column.phtml');\n        $this->renderLayout();\n    }\n\n    public function saveImageAction() {\n        if ($data = $this->getRequest()->getPost()) {\n            // Save the image and validate data\n            try {\n                // Assuming you have a model to handle saving images\n                Mage::getModel('specialcheckout/image')->saveImages($data);\n                \n                // Redirect back to cart or wherever you need\n                $this->_redirect('checkout/cart');\n            } catch (Exception $e) {\n                Mage::getSingleton('core/session')->addError($e->getMessage());\n                $this->_redirect('*/*/upload');\n            }\n        } else {\n            $this->_redirect('*/*/upload');\n        }\n    }\n}