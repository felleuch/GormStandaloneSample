package com.faiez.gorm

import com.faiez.gorm.domain.Person
import com.faiez.gorm.service.PersonService
import org.springframework.context.ApplicationContext
import grails.spring.BeanBuilder
import org.junit.Test
import static org.junit.Assert.assertEquals


class GormIntegrationTest {

        @Test
        void testPersistence() {
                BeanBuilder beanBuilder = new BeanBuilder()
                beanBuilder.loadBeans("classpath:SpringBeans.groovy")

                ApplicationContext context = beanBuilder.createApplicationContext()

                PersonService personService = context.getBean("personService") as PersonService

                Person person = new Person("firstName": "Faiez", "lastName":"ELLEUCH")
                personService.save(person)

                List<Person> persons = personService.findAll()

                assertEquals(persons.size(), 1)
                Person persistedPerson = persons[0]

                assertEquals(persistedPerson.firstName, "Faiez")
                assertEquals(persistedPerson.lastName,"ELLEUCH")
        }

}