//Добавить данные о репозитории и сделать его констурктор, гет\сет
// метод файнд алл принимает параметр ( фром, ту)
// возвращать массив только тех, что соответствуют условиям поиска
// сортировать по цене от меньшей к большей

package ru.netology.domain;


import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    public TicketRepository repository; // создаю репозиторий билетов

    public TicketManager(TicketRepository repository) { // конструтокр
        this.repository = repository;
    }

    public Ticket[] getTickets() {
        return repository.getTickets();
    }

    public void add(Ticket ticket) { // метод добавление билетов из репозитория
        repository.add(ticket);
    }

    // сравниваю объект вводимого значения аэропорт вылета
    public boolean matchesDeparture(Ticket ticket, String departureAirport) {
        return ticket.getDepartureAirport().equals(departureAirport);
    }

    // сравниваю объект вводимого значения аэропорт прилета
    public boolean matchesArrival(Ticket ticket, String arrivalAirport) {
        return ticket.getArrivalAirport().equals(arrivalAirport);
    }

    // создаю метод,который возвращает массив , который содержит данные фром и ту
    public Ticket[] findAll(String from, String to) { //
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];

            if (matchesDeparture(ticket, from)) {  // аэропорт вылета
                if (matchesArrival(ticket, to)) { // прилета
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
        }
        Arrays.sort(result); // сортирую результаты по цене от меньшего к большему
        return result;
    }
}
