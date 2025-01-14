import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GridControllerTest {

    interface DataService {
        List<Record> getRecords(int pageNumber, int pageSize, String sortBy, boolean ascending, List<String> filters);
    }

    static class Record {
        private final String name;
        private final int value; // Example field for sorting

        public Record(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() { return name; }
        public int getValue() { return value; }

        @Override
        public String toString() {
            return "Record{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    static class GridController {
        private DataService dataService;
        private int currentPage = 0;
        private int pageSize = 10;
        private String sortBy = "name";
        private boolean ascending = true;
        private List<String> filters = Collections.emptyList();

        public GridController(DataService dataService) {
            this.dataService = dataService;
        }

        public void setSort(String sortBy, boolean ascending) {
            this.sortBy = sortBy;
            this.ascending = ascending;
        }

        public void setFilters(List<String> filters) {
            this.filters = filters;
        }

        public void nextPage() {
            currentPage++;
        }

        public List<Record> getCurrentPageRecords() {
            return dataService.getRecords(currentPage, pageSize, sortBy, ascending, filters);
        }
    }

    @Mock
    private DataService mockDataService;

    private GridController gridController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gridController = new GridController(mockDataService);
    }

    @Test
    public void testGetCurrentPageRecordsWithDefaultSettings() {
        List<Record> expectedRecords = Arrays.asList(
                new Record("Alice", 28),
                new Record("Bob", 19)
        );

        when(mockDataService.getRecords(0, 10, "name", true, Collections.emptyList()))
                .thenReturn(expectedRecords);

        assertEquals(expectedRecords, gridController.getCurrentPageRecords());

        verify(mockDataService).getRecords(0, 10, "name", true, Collections.emptyList());
    }

    @Test
    public void testGetCurrentPageRecordsWithSorting() {
        List<Record> expectedRecords = Arrays.asList(
                new Record("Bob", 19),
                new Record("Alice", 28)
        );

        gridController.setSort("value", false); // Descending by value

        when(mockDataService.getRecords(0, 10, "value", false, Collections.emptyList()))
                .thenReturn(expectedRecords);

        assertEquals(expectedRecords, gridController.getCurrentPageRecords());

        verify(mockDataService).getRecords(0, 10, "value", false, Collections.emptyList());
    }

    @Test
    public void testGetCurrentPageRecordsWithFilters() {
        List<Record> expectedRecords = Arrays.asList(
                new Record("Alice", 28)
        );

        gridController.setFilters(Arrays.asList("name=Alice"));

        when(mockDataService.getRecords(0, 10, "name", true, Arrays.asList("name=Alice")))
                .thenReturn(expectedRecords);

        assertEquals(expectedRecords, gridController.getCurrentPageRecords());

        verify(mockDataService).getRecords(0, 10, "name", true, Arrays.asList("name=Alice"));
    }

    @Test
    public void testPagination() {
        List<Record> expectedSecondPage = Arrays.asList(
                new Record("Bob", 19)
        );

        gridController.nextPage(); // Move to second page
        when(mockDataService.getRecords(1, 10, "name", true, Collections.emptyList()))
                .thenReturn(expectedSecondPage);

        assertEquals(expectedSecondPage, gridController.getCurrentPageRecords());

        verify(mockDataService).getRecords(1, 10, "name", true, Collections.emptyList());
    }

    public static void main(String[] args) {
    }
}