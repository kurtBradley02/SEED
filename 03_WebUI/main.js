

async function ex1(){
    const response = await fetch("http://localhost:8080/refdb/1");
    const result = await response.text();
    alert(result);
}


if (typeof module !== "undefined") {
    module.exports = { ex1 };
}
