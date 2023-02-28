function maakTestStudent() {
    const req = new XMLHttpRequest();
    req.onload = function() {
        document.getElementById("test-vogel").innerHTML = this.responseText;
    }
   req.open("GET", "http://localhost:8090/api/vogel/testvogel");
   req.send();
}

async function zoekStudentOpNaam() {
    const naam = document.getElementById("naam").value;
    const res = await fetch(`http://localhost:8082/api/student/${naam}`);
    const data = await res.json();
    maakVogelResultaat(data);
}

async function haalAlleVogels(){
    const res = await fetch("http://localhost:8082/api/student/all")
    const data = await res.json();
    bouwVogelTabel(data);
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
    