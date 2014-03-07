package com.faiez.gorm.domain

import grails.persistence.Entity
import groovy.transform.EqualsAndHashCode


@Entity
@EqualsAndHashCode
class Person {
        /** The first name */
        String firstName

        /** The last name */
        String lastName

        /** Validation constraints */
        static constraints = {
                firstName size: 5..10, blank: false
                lastName size: 5..10, blank: false
        }

        String toString() {
                "Person {firstName=${firstName}, lastName=${lastName}}"
        }
}