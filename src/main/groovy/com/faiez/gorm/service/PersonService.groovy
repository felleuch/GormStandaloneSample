package com.faiez.gorm.service

import com.faiez.gorm.domain.Person


interface PersonService {
        /**
         * Persists a person
         * @param person A person
         */
        void save(Person person)

        /**
         * Validates the person domain constraints
         * @param person A person
         */
        boolean validate(Person person)

        /**
         * Returns all persons
         * @return All persons in the database
         */
        public List<Person> findAll()
}
