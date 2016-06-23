# camelsnake

[![Clojars Project](https://img.shields.io/clojars/v/fullcontact/camelsnake.svg)](https://clojars.org/fullcontact/camelsnake)
[![Build Status](https://travis-ci.org/fullcontact/camelsnake.svg?branch=master)](https://travis-ci.org/fullcontact/camelsnake)

A string casing conversion library. Supports the following casing styles:

* snake_case
* camelCase
* kebab-case

For transforming a string from any of the given formats, use one of the
conversion methods:

```clojure
(->camelCase "adventure-time") ; returns "adventureTime"
(->snake_case "adventure-time") ; returns "adventure_time"
(->kebab-case "adventureTime") ; returns "adventure-time"
```
