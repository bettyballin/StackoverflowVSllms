-- Customer references CreditCard and Order directly\nCustomer -> [1-n] Order, [1-n] CreditCard\n\n-- Order references Customer and CreditCard directly\nOrder -> [1-1] Customer, [1-1] CreditCard\n\n-- CreditCard references Customer directly\nCreditCard -> [1-n] Customer  // Not strictly necessary given your constraints