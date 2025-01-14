from django.views.generic.list import ListView\n\nclass ProfileListView(ListView):\n    model = Profile\n    template_name = 'profiles/profile_list.html'\n    context_object_name = 'profiles'\n\n    def get_queryset(self):\n        queryset = super().get_queryset()\n        profiles_list = sorted(queryset, key=lambda p: p.reputation)\n        return profiles_list\n\n    paginate_by = 10  # Example value