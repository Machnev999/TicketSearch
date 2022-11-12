package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

public class TicketRepository {

    Ticket[] tickets = new Ticket[0];


    public Ticket[] getTickets() {
        return tickets;
    }

    public Ticket[] findAll() {
        return tickets;
    }


    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(

                    "Element with id: " + id + " not found"
            );
        }
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int copyToindex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToindex] = ticket;
                copyToindex++;
            }
        }
        tickets = tmp;
    }

}



