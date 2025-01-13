from django.db.models import Q\n\nclass MyModelManager(models.Manager):\n    def full_outer_join(self, other_model):\n        return self.get_queryset().extra(\n            select={\n                'other_model_field': f'{other_model._meta.db_table}.field_name'\n            },\n            tables=[other_model._meta.db_table],\n            where=[\n                f'{self.model._meta.db_table}.id = {other_model._meta.db_table}.my_model_id'\n            ],\n            joins=[\n                f'FULL OUTER JOIN {other_model._meta.db_table} '\n                f'ON {self.model._meta.db_table}.id = {other_model._meta.db_table}.my_model_id'\n            ]\n        )\n\n# usage\nmy_model_manager = MyModelManager()\nresults = my_model_manager.full_outer_join(OtherModel)