(ns camelsnake.core-test
  (:require [camelsnake.core :refer :all]
            [clojure.test :refer :all]))


;;; Snake input

(deftest snake->snake-conversion
  (is (= (->snake_case "snake_case") "snake_case"))
  (is (= (->snake_case "oneword") "oneword"))
  (is (= (->snake_case "a_snake_case") "a_snake_case"))
  (is (= (->snake_case "f_o_o") "f_o_o"))
  (is (= (->snake_case "x_http_request") "x_http_request"))
  (is (= (->snake_case "foo_x") "foo_x"))
  (is (= (->snake_case "foo.bar_x") "foo.bar_x")))

(deftest snake->camel-conversion
  (is (= (->camelCase "snake_case") "snakeCase"))
  (is (= (->camelCase "oneword") "oneword"))
  (is (= (->camelCase "a_snake_case") "aSnakeCase"))
  (is (= (->camelCase "f_o_o") "fOO"))
  (is (= (->camelCase "x_http_request") "xHttpRequest"))
  (is (= (->camelCase "foo_x") "fooX"))
  (is (= (->camelCase "foo.bar_x") "foo.barX")))

(deftest snake->kebab-conversion
  (is (= (->kebab-case "snake_case") "snake-case"))
  (is (= (->kebab-case "oneword") "oneword"))
  (is (= (->kebab-case "a_snake_case") "a-snake-case"))
  (is (= (->kebab-case "f_o_o") "f-o-o"))
  (is (= (->kebab-case "x_http_request") "x-http-request"))
  (is (= (->kebab-case "foo_x") "foo-x"))
  (is (= (->kebab-case "foo.bar_x") "foo.bar-x")))


;;; Camel input

(deftest camel->camel-conversion
  (is (= (->camelCase "snakeCase") "snakeCase"))
  (is (= (->camelCase "oneword") "oneword"))
  (is (= (->camelCase "aSnakeCase") "aSnakeCase"))
  (is (= (->camelCase "ASnakeCase") "aSnakeCase"))
  (is (= (->camelCase "fOO") "fOo"))
  (is (= (->camelCase "xHttpRequest") "xHttpRequest"))
  (is (= (->camelCase "fooX") "fooX"))
  (is (= (->camelCase "foo.barX") "foo.barX")))

(deftest camel->snake-conversion
  (is (= (->snake_case "snakeCase") "snake_case"))
  (is (= (->snake_case "oneword") "oneword"))
  (is (= (->snake_case "aSnakeCase") "a_snake_case"))
  (is (= (->snake_case "ASnakeCase") "a_snake_case"))
  (is (= (->snake_case "FOO") "foo"))
  (is (= (->snake_case "FOo") "f_oo"))
  (is (= (->snake_case "xHttpRequest") "x_http_request"))
  (is (= (->snake_case "fooX") "foo_x"))
  (is (= (->snake_case "foo.barX") "foo.bar_x")))

(deftest camel->kebab-conversion
  (is (= (->kebab-case "snakeCase") "snake-case"))
  (is (= (->kebab-case "oneword") "oneword"))
  (is (= (->kebab-case "aSnakeCase") "a-snake-case"))
  (is (= (->kebab-case "ASnakeCase") "a-snake-case"))
  (is (= (->kebab-case "FOO") "foo"))
  (is (= (->kebab-case "foO") "fo-o"))
  (is (= (->kebab-case "HTTPRequest") "http-request"))
  (is (= (->kebab-case "FOO.HTTPServer") "foo.http-server"))
  (is (= (->kebab-case "foo.Bar") "foo.bar"))
  (is (= (->kebab-case "foo.bar") "foo.bar")))


;;; Kebab input

(deftest kebab->kebab-conversion
  (is (= (->kebab-case "snake-case") "snake-case"))
  (is (= (->kebab-case "oneword") "oneword"))
  (is (= (->kebab-case "a-snake-case") "a-snake-case"))
  (is (= (->kebab-case "foo") "foo"))
  (is (= (->kebab-case "fo-o") "fo-o"))
  (is (= (->kebab-case "http-request") "http-request"))
  (is (= (->kebab-case "foo.bar-request") "foo.bar-request")))

(deftest kebab->snake-conversion
  (is (= (->snake_case "snake-case") "snake_case"))
  (is (= (->snake_case "oneword") "oneword"))
  (is (= (->snake_case "a-snake-case") "a_snake_case"))
  (is (= (->snake_case "f-o-o") "f_o_o"))
  (is (= (->snake_case "x-http-request") "x_http_request"))
  (is (= (->snake_case "foo-x") "foo_x"))
  (is (= (->snake_case "foo.bar-x") "foo.bar_x")))

(deftest kebab->camel-conversion
  (is (= (->camelCase "snake-case") "snakeCase"))
  (is (= (->camelCase "oneword") "oneword"))
  (is (= (->camelCase "a-snake-case") "aSnakeCase"))
  (is (= (->camelCase "f-oo") "fOo"))
  (is (= (->camelCase "x-http-request") "xHttpRequest"))
  (is (= (->camelCase "foo-x") "fooX"))
  (is (= (->camelCase "foo.bar-x") "foo.barX"))
  (is (= (->camelCase "foo.bar") "foo.bar")))


(deftest case-conversions
  (is (= (->camelCase-keys {:old-index 5 :new-index 7 :very-old-index 1})
         {"oldIndex" 5 "newIndex" 7 "veryOldIndex" 1}))
  (is (= (->camelCase-keys {:oneword 3}) {"oneword" 3}))
  (is (= (->keyword "FooBarBaz") :foo-bar-baz))
  (is (= (->keyword "fooBarBaz") :foo-bar-baz))
  (is (= (->keyword "foobarbaz") :foobarbaz))
  (is (= (->keyword "FooBARBaz") :foo-bar-baz))
  (is (= (->keyword "FOOBARBAZ") :foobarbaz))
  (is (= (->keyword "XFullContactAccountId") :x-full-contact-account-id))
  (is (= (->keyword "iPod") :i-pod))
  (is (= (->keyword "iPod.bar") :i-pod.bar)))
