async function newVogel() {
    let data = {};
    data.naam = document.getElementById("naam").value;
    data.soort = document.getElementById("soort").value;
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