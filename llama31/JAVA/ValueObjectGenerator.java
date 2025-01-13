import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import javax.tools.*;
import java.util.*;
import java.io.*;

@SupportedAnnotationTypes("javax.annotation.Generated")
public class ValueObjectGenerator extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                generateValueObject(element);
            }
        }
        return true;
    }

    private void generateValueObject(Element element) {
        if (!(element instanceof TypeElement)) {
            return;
        }

        TypeElement typeElement = (TypeElement) element;
        String className = typeElement.getQualifiedName().toString();
        String generatedClassName = className + "Impl";

        // Generate class variables and constructor
        List<VariableElement> fields = new ArrayList<>();
        List<String> fieldNames = new ArrayList<>();
        for (Element enclosedElement : typeElement.getEnclosedElements()) {
            if (enclosedElement instanceof ExecutableElement) {
                ExecutableElement method = (ExecutableElement) enclosedElement;
                if (method.getKind() == ElementKind.METHOD && method.getReturnType().getKind() != TypeKind.VOID) {
                    String fieldName = method.getSimpleName().toString();
                    fields.add(new VariableElement(fieldName, method.getReturnType()));
                    fieldNames.add(fieldName);
                }
            }
        }

        // Generate equals, hashCode, toString methods
        String equalsMethod = generateEqualsMethod(fields);
        String hashCodeMethod = generateHashCodeMethod(fields);
        String toStringMethod = generateToStringMethod(fields);

        // Generate class implementation
        String classImplementation = "public class " + generatedClassName + " implements " + className + " {\n";
        for (VariableElement field : fields) {
            classImplementation += "    private final " + field.asType().toString() + " " + field.getSimpleName() + ";\n";
        }
        classImplementation += "    public " + generatedClassName + "(" + fieldNames.stream().map(fieldName -> className + " " + fieldName).collect(Collectors.joining(", ")) + ") {\n";
        for (String fieldName : fieldNames) {
            classImplementation += "        this." + fieldName + " = " + fieldName + ";\n";
        }
        classImplementation += "    }\n";
        classImplementation += equalsMethod + "\n";
        classImplementation += hashCodeMethod + "\n";
        classImplementation += toStringMethod + "\n";
        classImplementation += "}";

        // Write generated class to file
        try (Writer writer = processingEnv.getFiler().createSourceFile(generatedClassName).openWriter()) {
            writer.write(classImplementation);
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Error generating class: " + e.getMessage());
        }
    }

    private String generateEqualsMethod(List<VariableElement> fields) {
        String equalsMethod = "    @Override\n";
        equalsMethod += "    public boolean equals(Object obj) {\n";
        equalsMethod += "        if (this == obj) return true;\n";
        equalsMethod += "        if (obj == null || getClass() != obj.getClass()) return false;\n";
        equalsMethod += "        " + fields.get(0).getSimpleName() + " other = (" + fields.get(0).getSimpleName() + ") obj;\n";
        for (VariableElement field : fields) {
            equalsMethod += "        if (!" + field.getSimpleName() + ".equals(other." + field.getSimpleName() + ")) return false;\n";
        }
        equalsMethod += "        return true;\n";
        equalsMethod += "    }";
        return equalsMethod;
    }

    private String generateHashCodeMethod(List<VariableElement> fields) {
        String hashCodeMethod = "    @Override\n";
        hashCodeMethod += "    public int hashCode() {\n";
        hashCodeMethod += "        int result = 17;\n";
        for (VariableElement field : fields) {
            hashCodeMethod += "        result = 31 * result + " + field.getSimpleName() + ".hashCode();\n";
        }
        hashCodeMethod += "        return result;\n";
        hashCodeMethod += "    }";
        return hashCodeMethod;
    }

    private String generateToStringMethod(List<VariableElement> fields) {
        String toStringMethod = "    @Override\n";
        toStringMethod += "    public String toString() {\n";
        toStringMethod += "        return \"" + fields.get(0).getSimpleName() + "{\" +\n";
        for (VariableElement field : fields) {
            toStringMethod += "                \"" + field.getSimpleName() + ": \" + " + field.getSimpleName() + " +\n";
        }
        toStringMethod += "                \"}\";\n";
        toStringMethod += "    }";
        return toStringMethod;
    }

    public static void main(String[] args) {
    }
}