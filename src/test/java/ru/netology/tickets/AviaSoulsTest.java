package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldSortTickets() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 10);
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 13);
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 18);
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 2, 3);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);

        Ticket[] actual = service.search("Moscow", "Kursk");
        Ticket[] expected = {ticket2, ticket8, ticket4, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsIfFindOne() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 10);
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 13);
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 18);
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 2, 3);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);

        Ticket[] actual = service.search("Irkutsk", "Vladivostok");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsIfNoTickets() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 10);
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 13);
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 18);
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 2, 3);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);

        Ticket[] actual = service.search("Moscow", "Minsk");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSortTicketsWithTimeComparator() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 17);  //8
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 16);  //4
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 23);  //6
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 1, 4);  //3

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSortBy("Moscow", "Kursk", comparator);
        Ticket[] expected = {ticket8, ticket4, ticket6, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithTimeComparatorIfFindOne() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 17);
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 16);
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 23);
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);  //*
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 1, 4);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSortBy("Moscow", "Phuket", comparator);
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithTimeComparatorIfNoTickets() {
        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "SaintPetersburg", 300, 7, 8);
        Ticket ticket2 = new Ticket("Moscow", "Kursk", 100, 9, 17);
        Ticket ticket3 = new Ticket("Sochi", "Perm", 400, 10, 15);
        Ticket ticket4 = new Ticket("Moscow", "Kursk", 200, 12, 16);
        Ticket ticket5 = new Ticket("Irkutsk", "Vladivostok", 700, 3, 12);
        Ticket ticket6 = new Ticket("Moscow", "Kursk", 600, 17, 23);
        Ticket ticket7 = new Ticket("Moscow", "Phuket", 1000, 10, 20);
        Ticket ticket8 = new Ticket("Moscow", "Kursk", 150, 1, 4);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSortBy("Moscow", "Tver", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
