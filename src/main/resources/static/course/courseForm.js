async function newCourse() {
    let data = {};
    data.name = document.getElementById("name").value;
    data.credits = document.getElementById("credits").value;
    dataJSON = JSON.stringify(data);

    let res = await fetch("http://localhost:8082/api/course/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    let resdata = await res.json();
    console.log(data);
}


async function getAllCourses() {
    const res = await fetch("http://localhost:8082/api/course/all")
    const data = await res.json();
    buildContactPersonTable(data);
}

function buildContactPersonTable(data) {
    let tableBody = document.getElementById("courseTable");
    tableBody.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                          <td>${data[i].id}</td>
                          <td>${data[i].name}</td>
                          <td>${data[i].credits}</td>
                    </tr>`;
        tableBody.innerHTML += row;
    }
}
