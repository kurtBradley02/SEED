const test = require("node:test");
const assert = require("node:assert/strict");
const { ex1 } = require("./main.js");

test("ex1", () => {
    assert.equal(ex1(), "Hello World");
});


