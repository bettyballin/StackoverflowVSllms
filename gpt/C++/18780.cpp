#include "MyTemplateClass.h"\n\ntemplate <typename T>\nT MyTemplateClass<T>::staticMember;\n\n// Explicit instantiation definition\ntemplate class SHARED_API MyTemplateClass<int>;