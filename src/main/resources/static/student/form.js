async function newStudent() {
    let data = {};
    data.name = document.getElementById("name").value;
    data.grade = document.getElementById("grade").value;
    dataJSON = JSON.stringify(data);

    let res = await fetch("http://localhost:8082/api/student/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    let resdata = await res.json();
    console.log(data);
    }

async function getAllStudents() {
    const res = await fetch(`http://localhost:8082/api/student/all`)
    const data = await res.json();
    buildStudentTable(data);
}

function buildStudentTable(data) {
    let tableBody = document.getElementById("table");
    tableBody.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                      <td>${data[i].name}</td>
                      <td>${data[i].grade}</td>
                </tr>`;
        tableBody.innerHTML += row;
    }
}


async function mergeContactPersoonAndStudent() {
    let data = {};
    data.contactPersonId = document.getElementById("contactPersonId").value;
    data.studentId = document.getElementById("studentId").value;
    let res = await fetch(`http://localhost:8082/api/contactPerson/add/${data.contactPersonId}/${data.studentId}`, {
        method: "PUT"
    });
    console.log(res.status);
}

async function mergeCourseAndStudent() {
    let data = {};
    data.studentId2 = document.getElementById("studentId2").value;
    data.courseId = document.getElementById("courseId").value;
    let res = await fetch(`http://localhost:8082/api/course/add/${data.courseId}/${data.studentId2}`, {
        method: "PUT"
    });
    console.log(res.status);
}