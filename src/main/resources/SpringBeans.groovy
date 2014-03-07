import org.apache.commons.dbcp.BasicDataSource
import org.springframework.context.support.ResourceBundleMessageSource

beans {
        xmlns gorm:"http://grails.org/schema/gorm"
        xmlns context:"http://www.springframework.org/schema/context"
        xmlns tx:"http://www.springframework.org/schema/tx"

        messageSource(ResourceBundleMessageSource) {
                basename = "messages"
        }

        dataSource(BasicDataSource) {
                driverClassName = "org.h2.Driver"
                url = "jdbc:h2:mem:grailsDB"
                username = "sa"
                password = ""
        }

        gorm.sessionFactory("data-source-ref": "dataSource",
                            "base-package": "com.faiez.gorm.domain",
                            "message-source-ref": "messageSource") {
                hibernateProperties = ["hibernate.hbm2ddl.auto": "update",
                                       "hibernate.dialect": "org.hibernate.dialect.H2Dialect"]
        }

        context."component-scan"("base-package": "com.faiez.gorm")
        context."annotation-config"()

        tx."annotation-driven"()
}