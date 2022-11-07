//1. создать и унаследоваться от рантайм
//2. отправлять отчет и сообщение

package ru.netology.domain;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
