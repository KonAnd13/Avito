package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.model.House;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service = new HouseService();
    private List<House> target;
    private List<House> result;

    @Test
    void searchByPrice() {
        target = Arrays.asList(
                new House(4, 100000, 1, "Glockenbach", "Lehel"),
                new House(2, 160000, 1, "Trudering", "Moosach"),
                new House(8, 200000, 2, "Trudering", "Moosach")
        );
        result = service.searchByPrice(100000, 300000, (o1, o2) -> o1.getPrice() - o2.getPrice());
        assertEquals(target, result);
    }

    @Test
    void searchByMetro() {
        target = Arrays.asList(
                new House(1, 350000, 1, "Maxvorstadt", "Harthof"),
                new House(10, 480000, 1, "Maxvorstadt", "Harthof"),
                new House(6, 570000, 2, "Bogenhausen", "Stroxo")
        );
        result = service.searchByMetro((o1, o2) -> o1.getPrice() - o2.getPrice(), "Harthof", "Stroxo");
        assertEquals(target, result);
    }

    @Test
    void sortBy() {
        target = Arrays.asList(
                new House(7, 1240000, 3, "Nymphenburg-Neuhausen", "Nymphenburg"),
                new House(5, 950000, 3, "Brayton", "Riem"),
                new House(3, 750000, 2, "Brayton", "Riem"),
                new House(9, 750000, 1, "Brayton", "Riem"),
                new House(6, 570000, 2, "Bogenhausen", "Stroxo"),
                new House(10, 480000, 1, "Maxvorstadt", "Harthof"),
                new House(1, 350000, 1, "Maxvorstadt", "Harthof"),
                new House(8, 200000, 2, "Trudering", "Moosach"),
                new House(2, 160000, 1, "Trudering", "Moosach"),
                new House(4, 100000, 1, "Glockenbach", "Lehel")
        );
        result = service.sortBy((o1, o2) -> -(o1.getPrice() - o2.getPrice()));
        assertEquals(target, result);
    }
}