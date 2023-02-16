async function zoekStudentOpNaam() {
    const naam = document.getElementById("naam").value;
    const res = await fetch(`http://localhost:8082/api/leerling/${naam}`);
    const data = await res.json();
    maakVogelResultaat(data);
}