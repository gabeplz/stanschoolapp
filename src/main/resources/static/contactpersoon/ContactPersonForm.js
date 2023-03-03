async function newContactPerson() {
    let data = {};
    data.name = document.getElementById("name").value;
    data.phoneNumber = document.getElementById("phoneNumber").value;
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

    
        async function getAllContactPersons(){
            const res = await fetch("http://localhost:8082/api/contactPerson/all")
            const data = await res.json();
            buildContactPersonTable(data);
        }
    
        function buildContactPersonTable(data){
            let tableBody = document.getElementById("table");
                tableBody.innerHTML = "";
                for (let i=0; i< data.length; i++){
                    let row = `<tr>
                          <td>${data[i].id}</td>
                          <td>${data[i].name}</td>
                          <td>${data[i].phoneNumber}</td>
                    </tr>`;
                tableBody.innerHTML += row;
                }
            }

