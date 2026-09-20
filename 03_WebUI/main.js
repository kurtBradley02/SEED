

async function fromRefDb(){
    const response = await fetch("http://localhost:8080/refdb/1");
    const result = await response.text();
    alert(result);
}

function ex1(){
    return "Hello World";
}


if (typeof module !== "undefined") {
    module.exports = { ex1 };
}
