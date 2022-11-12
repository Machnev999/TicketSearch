import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class RepositoryTest {

    TicketRepository repository = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 100, "DME", "SVO", 120);
    Ticket ticket2 = new Ticket(2, 400, "OGZ", "LED", 120);
    Ticket ticket3 = new Ticket(3, 300, "MOV", "LED", 120);
    Ticket ticket4 = new Ticket(4, 200, "OGZ", "LED", 120);
    Ticket ticket5 = new Ticket(5, 100, "DME", "SVO", 120);
    Ticket ticket6 = new Ticket(6, 110, "OGZ", "LED", 120);


    @Test
    public void shouldAddTicket() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveOneTicketById() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        repository.removeById(6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFoundRemoveTicket() {
        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(9));
    }


}
