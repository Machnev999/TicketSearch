import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketManager;
import ru.netology.repository.TicketRepository;

public class ManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 100, "DME", "SVO", 120);
    Ticket ticket2 = new Ticket(2, 400, "OGZ", "LED", 120);
    Ticket ticket3 = new Ticket(3, 300, "MOV", "LED", 120);
    Ticket ticket4 = new Ticket(4, 200, "OGZ", "LED", 120);
    Ticket ticket5 = new Ticket(5, 100, "DME", "SVO", 120);
    Ticket ticket6 = new Ticket(6, 110, "OGZ", "LED", 120);

    @Test
    public void shouldAddTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketFromEqualsAirportTransfer() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.findAll("DME", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoOneTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketsFindAllSortFromMinToMaxPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket6, ticket4, ticket2};
        Ticket[] actual = manager.findAll("OGZ", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

}
