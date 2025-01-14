// app/Controller/GuestBookController.php\nclass GuestBookController extends AppController {\n    public $components = array('NewsPost', 'ShortFact');\n\n    public function index() {\n        $guestBookNotes = $this->GuestBookNote->find('all');\n        $newsPost = $this->NewsPost->getLatest();\n        $shortFact = $this->ShortFact->getRandom();\n\n        $this->set(compact('guestBookNotes', 'newsPost', 'shortFact'));\n    }\n}