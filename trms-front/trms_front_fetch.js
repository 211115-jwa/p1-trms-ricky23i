



async function getRequestByID() {
   
    let response = await fetch(trmsAppUrl + 'requests/requestor/' + document.getElementById('empid').value);
    if (response.status === 200) {
        let requests = await response.json();
        console.log(requests);
        showRequests(requests);
    }
}


function showRequests(requests) {
    let requestTable = document.getElementById('AllRequests');

    for (let request of requests) {
        let rows = document.createElement('tr');

        for (let field in request) {
            let column = document.createElement('td');
            column.innerText = request[field];
            rows.appendChild(column);


        }
        requestTable.appendChild(rows);
    }
}

