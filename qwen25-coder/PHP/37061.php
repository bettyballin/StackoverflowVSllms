// controllers/HomeController.php (This is your Page Controller)\nclass HomeController {\n    public static function showHome() {\n        $data = Model::getHomeData(); // Delegate data fetching to Model\n        require 'views/home.php';       // Render view with fetched data\n    }\n}