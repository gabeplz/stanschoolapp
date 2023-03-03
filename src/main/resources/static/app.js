// function maakTestStudent() {
//     const req = new XMLHttpRequest();
//     req.onload = function() {
//         document.getElementById("test-vogel").innerHTML = this.responseText;
//     }
//    req.open("GET", "http://localhost:8090/api/vogel/testvogel");
//    req.send();
// }

async function searchStudentByName() {
    const searchName = document.getElementById("searchName").value;
    const res = await fetch(`http://localhost:8082/api/student/by_name/${searchName}`);
    const data = await res.json();
    buildStudentByNameTable(data);
}

async function searchStudentById() {
    console.log("searchStudentById launch")
    const searchId = document.getElementById("searchId").value;
    const res = await fetch(`http://localhost:8082/api/student/by_id/${searchId}`);
    const data2 = await res.json();
    console.log("data2");
    console.log(data2);
    console.log("data2");
    buildStudentByIdTable(data2);
}


// function buildStudentTable(data,number) {
//     if (number == 2){
//         let tableBody = document.getElementById("SearchIdTable");
//         console.log("number is 2")
//     } else {  
//         console.log("number is else")
//         let tableBody = document.getElementById("SearchNameTable");}
    
//     tableBody.innerHTML = "";
//     for (let i = 0; i < data.length; i++) {
//         for (let x = 0; x < data[i].courses.length; x++) {
//             let row = `<tr>
//                         <td>${data[i].id}</td>
//                         <td>${data[i].name}</td>
//                         <td>${data[i].grade}</td>
//                         <td>${data[i].school.id}</td>
//                         <td>${data[i].contactPerson.id}<td>
//                         <td>${data[i].courses[x].id}</td>
//                         </tr>`;
//             tableBody.innerHTML += row;
//         }

//     }
// }

function buildStudentByNameTable(data) {
    console.log("data.length " + data.length);
    let tableBody = document.getElementById("SearchNameTable");
    
    tableBody.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        for (let x = 0; x < data[i].courses.length; x++) {
            let row = `<tr>
                        <td>${data[i].id}</td>
                        <td>${data[i].name}</td>
                        <td>${data[i].grade}</td>
                        <td>${data[i].school.id}</td>
                        <td>${data[i].contactPerson.id}<td>
                        <td>${data[i].courses[x].id}</td>
                        </tr>`;
            tableBody.innerHTML += row;
        }
    }
}


function buildStudentByIdTable(data2) {
    console.log("buildStudentByIdTable");
    console.log(data2)
    let tableBody = document.getElementById("SearchIdTable");
    tableBody.innerHTML = "";
    console.log("buildStudentByIdTable");
    console.log("data2.length " + data2.length);
    console.log("data2.id " + data2.id);
    console.log("data2.name " + data2.name);
    
    console.log("outerloop");
    for (let x = 0; x < data2.courses.length; x++) {
        console.log("innerloop");
        let row = `<tr>
                        <td>${data2.id}</td>
                        <td>${data2.name}</td>
                        <td>${data2.grade}</td>
                        <td>${data2.school.id}</td>
                        <td>${data2.contactPerson.id}<td>
                        <td>${data2.courses[x].id}</td>
                        </tr>`;
        tableBody.innerHTML += row;
    }

    console.log("end");
}

async function buildTest(){
    newStudent()
    newContactPerson()
    newCourse()
    newSchool()

}



async function newStudent() {
    let data = {};
    data.name = "stan";
    data.grade = 1;
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

async function newContactPerson() {
    let data = {};
    data.name = "paps";
    data.phoneNumber = "0669";
    dataJSON = JSON.stringify(data);

    let res = await fetch("http://localhost:8082/api/contactPerson/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    let resdata = await res.json();
    console.log(data);
    }

    async function newCourse() {
        let data = {};
        data.name = "techniek";
        data.credits = 9;
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
    
    async function newSchool() {
        
        let data = {};
        data.name = "techniek";
        data.amountOfStudents = 9;
        data.city = "zeeland";
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
    