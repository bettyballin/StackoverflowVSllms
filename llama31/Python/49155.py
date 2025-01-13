from tg import expose, TGController\n\nclass RootController(TGController):\n    @expose()\n    def index(self):\n        return "Hello, World!"\n\nfrom tg import AppConfig\nfrom tg.configuration import milestones\n\nconfig = AppConfig(minimal=True, root_controller=RootController())\nmilestones._reach_milestone("config_ready")