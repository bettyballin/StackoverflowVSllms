<?php\n   class CronjobsController {\n       public function processOrders() {\n           // Logic to process orders every 15 minutes\n           // Example:\n           // $orders = OrderModel::getPendingOrders();\n           // foreach($orders as $order) {\n           //     $order->process();\n           // }\n       }\n\n       public function newUserRegistrations() {\n           // Logic to accept new user registrations every 60 minutes\n           // Example:\n           // $registrations = UserModel::getPendingRegistrations();\n           // foreach($registrations as $registration) {\n           //     $registration->approve();\n           // }\n       }\n\n       public function dailyTasks() {\n           // Logic to handle daily tasks\n       }\n   }