import java.io.File;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "profiles")
class Profiles {
    @ElementList(inline = true, entry = "profile")
    private List<Profile> profiles;

    public Profiles() {}

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}

@Root(name = "profile")
class Profile {
    @Element(name = "id")
    private int id;

    @Element(name = "name")
    private String name;

    @ElementList(inline = true, entry = "lang")
    private List<String> langs;

    public Profile() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    } 

    @Override
    public String toString() {
        return "Profile [id=" + id + ", name=" + name + ", langs=" + langs + "]";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Serializer serializer = new Persister();
        File source = new File("input.xml"); // Your input file
        List<Profile> profiles  = serializer.read(Profiles.class, source).getProfiles();
        // Now in the list "profiles", each element will have its langs stored as multiple values within "lang" tags.
        System.out.println(profiles);
    }
}