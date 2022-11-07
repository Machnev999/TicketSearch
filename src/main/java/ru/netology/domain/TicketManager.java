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

    public TicketRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketRepository repository) {
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
        if (ticket.getDepartureAirport().equals(departureAirport)) {
            return true;
        } else {
            return false;
        }
    }

    // сравниваю объект вводимого значения аэропорт прилета
    public boolean matchesArrival(Ticket ticket, String arrivalAirport) {
        if (ticket.getArrivalAirport().equals(arrivalAirport)) {
            return true;
        } else {
            return false;
        }
    }

    // создаю метод,который возвращает массив , который содержит данные фром и ту
    public Ticket[] findAll(String from, String to) { //
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];

            if (matchesDeparture(ticket, from)) {  // аэропорт вылета
                if (matchesArrival(ticket, to)) { // прилета
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
        }
        Arrays.sort(result); // сортирую результаты по цене от меньшего к большему
        return result;
    }
}
