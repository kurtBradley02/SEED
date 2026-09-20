const test = require("node:test");
const assert = require("node:assert/strict");
const { ex1, ex2, ex3, ex4 } = require("./main.js");

// Each test swaps global.fetch for a fake that records the URL it was
// called with and returns a canned response, and swaps global.alert for
// a fake that records what it was shown. Real network calls / real
// browser dialogs never happen during the test run.
function stubFetch(responseText) {
    let calledUrl;
    global.fetch = async (url) => {
        calledUrl = url;
        return { text: async () => responseText };
    };
    return () => calledUrl;
}

function stubAlert() {
    let shown;
    global.alert = (msg) => { shown = msg; };
    return () => shown;
}

test("ex1 calls /ex1 and alerts the raw response text", async () => {
    const getUrl = stubFetch("Hello World");
    const getAlert = stubAlert();

    await ex1();

    assert.equal(getUrl(), "http://localhost:8080/ex1");
    assert.equal(getAlert(), "Hello World");
});

test("ex2 calls /ex2 with a=1&b=2", async () => {
    const getUrl = stubFetch("3");
    const getAlert = stubAlert();

    await ex2();

    assert.equal(getUrl(), "http://localhost:8080/ex2?a=1&b=2");
    assert.equal(getAlert(), "3");
});

test("ex3 calls /ex3 with a=6&b=3", async () => {
    const getUrl = stubFetch("SUM: 9");
    const getAlert = stubAlert();

    await ex3();

    assert.equal(getUrl(), "http://localhost:8080/ex3?a=6&b=3");
    assert.equal(getAlert(), "SUM: 9");
});

test("ex4 calls /ex4 with a=2", async () => {
    const getUrl = stubFetch("Even");
    const getAlert = stubAlert();

    await ex4();

    assert.equal(getUrl(), "http://localhost:8080/ex4?a=2");
    assert.equal(getAlert(), "Even");
});
