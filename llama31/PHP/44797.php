// app/code/local/YourCompany/YourModule/Model/Quote/Discount.php\n\nclass YourCompany_YourModule_Model_Quote_Discount extends Mage_SalesRule_Model_Quote_Discount\n{\n    public function fetch(Mage_Sales_Model_Quote_Item_Abstract $item)\n    {\n        // Call the parent method\n        parent::fetch($item);\n\n        // Get the coupon code\n        $couponCode = $this->getQuote()->getCouponCode();\n\n        // Display the coupon code even if the discount is zero\n        if ($couponCode) {\n            $item->setData('coupon_code', $couponCode);\n        }\n\n        return $this;\n    }\n}