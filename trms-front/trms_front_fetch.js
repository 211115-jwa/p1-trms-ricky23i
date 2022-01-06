



async function getRequestByID() {
   
    let response = await fetch(trmsAppUrl + 'requests/requestor/' + document.getElementById('empid').value);
    if (response.status === 200) {
        let requests = await response.json();
        console.log(requests);
        if (requests.length == 0)
            alert('No requests found');
        showRequests(requests);
    }
}


function showRequests(requests) {
    let requestTable = document.getElementById('requestsID');

    for (let request of requests) {
        let rows = document.createElement('tr');
       // console.log(request);
        for (let field in request) {
            let column = document.createElement('td');
            let o = JSON.parse(JSON.stringify(request[field]));
            console.log(field);
            if (field == 'reqId') {
              //  console.log(o);
                column.innerText = o;
                rows.appendChild(column);
            }
            else if (field == 'requestor') {
                column.innerText = o.firstName + ' ' + o.lastName;
                rows.appendChild(column);
            }
            else if (field == 'status') {
                column.innerText = o.name;
                rows.appendChild(column);
                let c2 = document.createElement('tr');
                c2.innerText = o.approver;
                rows.appendChild(c2);
            }
            else if (field == 'description') {

                column.innerText = o;
                rows.appendChild(column);
            }
        
        


        }
        requestTable.appendChild(rows);
    }
}

