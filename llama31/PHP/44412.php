$objectManager = \Magento\Framework\App\ObjectManager::getInstance();\n$customerSession = $objectManager->get('Magento\Customer\Model\Session');\n$customer = $customerSession->getCustomer();\n\nif ($customer->getId()) {\n    $name = $customer->getName();\n    // Do something with the customer's name\n} else {\n    // Customer is not logged in\n}