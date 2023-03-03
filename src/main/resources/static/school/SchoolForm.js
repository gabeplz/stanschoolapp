async function newSchool() {
        
    let data = {};
    data.name = document.getElementById("name").value;
    data.amountOfStudents = document.getElementById("amountOfStudents").value;
    data.city = document.getElementById("city").value;
    dataJSON = JSON.stringify(data);

    let res = await fetch("http://localhost:8082/api/school/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    let resdata = await res.json();
    console.log(data);
}


async function getAllSchools(){
    const res = await fetch("http://localhost:8082/api/school/all")
    const data = await res.json();
    buildSchoolTable(data);
}

function buildSchoolTable(data){
    let tableBody = document.getElementById("schoolTable");
        tableBody.innerHTML = "";
        for (let i=0; i< data.length; i++){
            let row = `<tr>
                  <td>${data[i].id}</td>
                  <td>${data[i].name}</td>
                  <td>${data[i].amountOfStudents}</td>
                  <td>${data[i].city}</td>
            </tr>`;
        tableBody.innerHTML += row;
        }
    }