async function newContactPerson() {
    let data = {};
    data.naam = document.getElementById("name").value;
    data.soort = document.getElementById("phoneNumber").value;
    dataJSON = JSON.stringify(data);

    let res = await fetch("http://localhost:8082/api/leerling/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    let resdata = await res.json();
    console.log(data);
    }