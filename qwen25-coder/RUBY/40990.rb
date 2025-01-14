Name:           your_project_name\nVersion:        1.0\nRelease:        1%{?dist}\nSummary:        Your project summary\n\nLicense:        BSD\nURL:            https://yourprojecturl.com/\nSource0:        %{name}-%{version}.tar.gz\n\nRequires:       some_non_python_dependency\n\nBuildArch:      noarch\nBuildRequires:  python3-devel, setuptools, your_development_dependencies\n\n%description\nYour project description goes here.\n\n%prep\n%setup -q\n\n%build\npython3 setup.py build\n\n%install\npython3 setup.py install --root %{buildroot}\n\n# Include any necessary files here and specify the installation path\n\n%post\n/bin/sh %{_bindir}/your_post_install_script.sh\n\n%files\n%{python3_sitelib}/your_package/*\n/usr/local/bin/your_script\n\n%changelog\n* Sun Jan 01 2023 Your Name <your.email@example.com> - 1.0\n- Initial package.