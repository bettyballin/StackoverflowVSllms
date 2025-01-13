//External script - Load magento framework\nrequire_once("C:\Program Files\Apache Software Foundation\Apache2.2\htdocs\magento\app\Mage.php");\nMage::app('default');\n\n$myOrder=Mage::getModel('sales/order'); \n$orders=Mage::getModel('sales/mysql4_order_collection');\n\n//Optional filters you might want to use - more available operations in method _getConditionSql in Varien_Data_Collection_Db. \n$orders->addFieldToFilter('total_paid',Array('gt'=>0)); //Amount paid larger than 0\n$orders->addFieldToFilter('status',Array('eq'=>"processing"));  //Status is "processing"\n\n$allIds=$orders->getAllIds();\nforeach($allIds as $thisId) {\n    $myOrder->reset()->load($thisId);\n    //echo "<pre>";\n    //print_r($myOrder);\n    //echo "</pre>";\n\n    //Some random fields\n    echo "'" . $myOrder->getBillingAddress()->getLastname() . "',";\n    echo "'" . $myOrder->getTotal_paid() . "',";\n    echo "'" . $myOrder->getShippingAddress()->getTelephone() . "',";\n    echo "'" . $myOrder->getPayment()->getCc_type() . "',";\n    echo "'" . $myOrder->getStatus() . "',";\n    echo "\r\n";\n}