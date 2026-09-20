

async function ex1(){
    const response = await fetch("http://localhost:8080/ex1");
    const result = await response.text();
    alert(result);
}

async function ex2(){
    const response = await fetch("http://localhost:8080/ex2?a=1&b=2");
    const result = await response.text();
    alert(result);
}

async function ex3(){
    const response = await fetch("http://localhost:8080/ex3?a=6&b=3");
    const result = await response.text();
    alert(result);
}

async function ex4(){
    const response = await fetch("http://localhost:8080/ex4?a=2");
    const result = await response.text();
    alert(result);
}

/*TODO:
test layer for ui unit and e2e
bind all and make data come from db > api > ui
*/

// Exposes these functions to Node's test runner via require().
// `typeof module` is undefined in the browser, so this is a no-op there.
if (typeof module !== "undefined") {
    module.exports = { ex1, ex2, ex3, ex4 };
}
