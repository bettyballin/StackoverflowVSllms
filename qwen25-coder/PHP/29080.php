// Example of Joomla's simple MVC pattern structure\n\n// Model: typically found in components/com_example/models/yourmodel.php\nclass ExampleModelYourModel extends JModelList {\n    // Your model methods go here\n}\n\n// View: typically found in components/com_example/views/yourview/tmpl/default.php\n<h1><?php echo $this->items[0]->title; ?></h1>\n\n// Controller: typically found in components/com_example/controller.php\nclass ExampleController extends JControllerLegacy {\n    // Your controller methods go here\n}