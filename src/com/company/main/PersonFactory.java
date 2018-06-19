package com.company.main;

interface PersonFactory<T extends Person> {
    T create(String firstName, String lastName);
}
