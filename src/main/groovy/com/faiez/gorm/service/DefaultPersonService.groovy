
package com.faiez.gorm.service

import org.springframework.stereotype.Service
import com.faiez.gorm.domain.Person
import org.springframework.transaction.annotation.Transactional


@Service("personService")
@Transactional
class DefaultPersonService implements PersonService {
        void save(Person person) {
                person.save()
        }

        boolean validate(Person person) {
                person.validate()
        }

        public List<Person> findAll() {
                Person.findAll()
        }
}