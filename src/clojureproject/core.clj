(ns clojureproject.core
  (:require [clojure.java.jdbc :as sql]))

(def db {:classname "org.postgresql.Driver"
         :subprotocol "postgresql"
         :subname "//localhost:5432/clojuredb"
         :user "postgres"
         :password ""})

(defn list-records []
  (sql/query db
      ["select * from testing"]))
(defn insert-records []
  (sql/insert! db
      :testing {:id 4 :data "Fourth Record"}))
(defn delete-records []
  (sql/db-do-commands db
      ["delete from testing"]))
