package com.faiez.gorm

import com.faiez.gorm.domain.Person
import com.faiez.gorm.service.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.MessageSource
import org.springframework.validation.FieldError
import grails.spring.BeanBuilder


class Application {
        private static final Logger LOG = LoggerFactory.getLogger(Application.class)

        static main(args) {

                BeanBuilder beanBuilder = new BeanBuilder()
                beanBuilder.loadBeans("classpath:SpringBeans.groovy")

                ApplicationContext context = beanBuilder.createApplicationContext()
                MessageSource msg = context.getBean("messageSource") as MessageSource


                PersonService personService = context.getBean("personService") as PersonService


                def persons = [
                        new Person("firstName":"Amin", "lastName":"ZOUARI"),
                        new Person("firstName":"Faiez", "lastName":"ELLEUCH")
                ]

                LOG.info("About to load users: ${persons}")

                // Save person if validation constraints are met
                persons.each { person ->
                        if (personService.validate(person)) {
                                personService.save(person)
                                LOG.info("Successfully saved ${person}")
                        }
                        else {
                                // print validation errors
                                person.errors.allErrors.each { FieldError error ->
                                        LOG.error(msg.getMessage(error, Locale.getDefault()))
                                }
                        }
                }
                
                LOG.info ("All Persons:  ${personService.findAll()}")
        }

}
