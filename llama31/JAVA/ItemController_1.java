import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

@RestController
public class ItemController_1_1 {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Item> getItems(@RequestParam List<Long> ids, @RequestParam Map<String, String> filterValues) {
        // create a specification for filtering
        Specification<Item> spec = (root, criteriaQuery, criteriaBuilder) -> {
            // implement your filter logic here
            Predicate predicate = criteriaBuilder.conjunction();
            if (filterValues.containsKey("letter")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("name"), filterValues.get("letter") + "%"));
            }
            if (filterValues.containsKey("status")) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), filterValues.get("status")));
            }
            return predicate;
        };
        
        // query the database with the specification and IDs
        return itemRepository.findAllById(ids).stream()
            .filter(spec::isSatisfiedBy)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
    }
}