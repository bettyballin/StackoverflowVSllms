import java.util.List;
import java.util.ArrayList;

@RestController
public class MyResource_2 {
    @GetMapping("/my-resource")
    public MyResponse getResources() {
        List<Item> items = new ArrayList<>();
        //... populate items from some data source.

        MyResponse response = new MyResponse();
        response.setItems(items);
        buildLinks(response);
        return response;
    }

    private void buildLinks(MyResponse response) {
        Link selfLink = linkTo(methodOn(MyResource.class).getResources()).withSelfRel();

        List<Item> items = response.getItems();
        for (int i=0; i < items.size(); i++) {
            Item item = items.get(i);
            Link itemLink = linkTo(methodOn(MyResource.class).findOne(item)).withRel("item:"+i);
            item.add(itemLink);
        }

        response.addLink(selfLink);
    }

    public static void main(String[] args) {
    }

    // Additional definitions
    public static class MyResponse {
        private List<Item> items = new ArrayList<>();
        private List<Link> links = new ArrayList<>();

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }

        public void addLink(Link link) {
            links.add(link);
        }
    }

    public static class Item {
        private List<Link> links = new ArrayList<>();

        public void add(Link link) {
            links.add(link);
        }
    }

    public static class Link {
        private String rel;

        public Link(String rel) {
            this.rel = rel;
        }
    }

    public static class MyResource {
        public MyResponse getResources() {
            return null;
        }

        public Item findOne(Item item) {
            return item;
        }
    }

    public static <T> T methodOn(Class<T> controllerClass) {
        try {
            return controllerClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public static LinkBuilder linkTo(Object methodCall) {
        return new LinkBuilder();
    }

    public static class LinkBuilder {
        public Link withSelfRel() {
            return new Link("self");
        }

        public Link withRel(String rel) {
            return new Link(rel);
        }
    }

    public @interface RestController {}

    public @interface GetMapping {
        String value();
    }
}