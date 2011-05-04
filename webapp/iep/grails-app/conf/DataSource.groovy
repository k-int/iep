dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
          // driverClassName = "com.mysql.jdbc.Driver"
          // dbCreate =  "update" // "create-drop"           // "create"
          // username = "k-int"
          // password = "k-int"
          // url = "jdbc:mysql://localhost/FIDYDev?autoReconnect=true&amp;characterEncoding=utf8"
          // properties {
          //   validationQuery="select 1"
          //   testWhileIdle=true
          //   timeBetweenEvictionRunsMillis=60000
          // }

          dbCreate = "create-drop" // one of 'create', 'create-drop','update'
          url = "jdbc:hsqldb:mem:devDB"
        }
    }
    test {
        dataSource {
          driverClassName = "com.mysql.jdbc.Driver"
          dbCreate =  "update" // "create-drop"           // "create"
          username = "k-int"
          password = "k-int"
          url = "jdbc:mysql://localhost/FIDYTest?autoReconnect=true&amp;characterEncoding=utf8"
          properties {
            validationQuery="select 1"
            testWhileIdle=true
            timeBetweenEvictionRunsMillis=60000
          }
          // dbCreate = "update"
          // url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
          driverClassName = "com.mysql.jdbc.Driver"
          dbCreate =  "update" // "create-drop"           // "create"
          username = "k-int"
          password = "k-int"
          url = "jdbc:mysql://localhost/FIDYLive?autoReconnect=true&amp;characterEncoding=utf8"
          properties {
            validationQuery="select 1"
            testWhileIdle=true
            timeBetweenEvictionRunsMillis=60000
          }

          // dbCreate = "update"
          // url = "jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}
