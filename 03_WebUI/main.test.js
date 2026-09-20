const test = require("node:test");
const assert = require("node:assert/strict");
const { ex1 } = require("./main.js");

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

test("refdb/1", async () => {
    const getUrl = stubFetch('{"id":1,"a":1,"b":0}');
    const getAlert = stubAlert();

    await ex1();

    assert.equal(getUrl(), "http://localhost:8080/refdb/1");
    assert.equal(getAlert(), '{"id":1,"a":1,"b":0}');
});


