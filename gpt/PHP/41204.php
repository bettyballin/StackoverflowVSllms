// src/Controller/GuestBookController.php\n\nnamespace App\Controller;\n\nuse App\Controller\AppController;\n\nclass GuestBookController extends AppController\n{\n    public function index()\n    {\n        // Load the required models\n        $this->loadModel('NewsPosts');\n        $this->loadModel('ShortFacts');\n        $this->loadModel('GuestBookNotes');\n        \n        // Fetch data\n        $newsPosts = $this->NewsPosts->find('all')->limit(5); // Example: fetch the latest 5 news posts\n        $shortFacts = $this->ShortFacts->find('all')->order('rand()')->first(); // Get a random short fact\n        $guestBookNotes = $this->GuestBookNotes->find('all'); // Fetch guest book notes\n        \n        // Pass data to the view\n        $this->set(compact('newsPosts', 'shortFacts', 'guestBookNotes'));\n    }\n}