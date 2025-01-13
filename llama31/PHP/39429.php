class CommentsController extends AppController {\n    public function add($personId) {\n        if ($this->request->is('post')) {\n            $this->Comment->create();\n            $this->Comment->save(array(\n                'person_id' => $personId,\n                'text' => $this->request->data['Comment']['text']\n            ));\n            $this->Session->setFlash(__('Comment added'));\n            $this->redirect(array('controller' => 'people', 'action' => 'view', $personId));\n        }\n    }\n}