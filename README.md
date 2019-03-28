# shadow-cljs-kitchen-async-puppeteer

An example demonstarting automated async browser tests with:

- shadow-cljs
- kitchen-async
- puppeteer
- cljs.test

## Setup

1. Get `clojure` command working
1. `npm install -g shadow-cljs`
1. `npm install puppeteer`

## node repl

1. `shadow-cljs node-repl`

## running tests

1. `shadow-cljs compile`
1. `node target/check-all.js`
