



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
       //console.log(request);
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

async function getEmployByID(id) {

    let response = await fetch(trmsAppUrl + 'emp/' + id);
    if (response.status === 200) {
        let emp = await response.json();
        if (emp == null)
            alert('No current employee found');
        return emp;
    }
}

//todo
function getEventTypeID(id) {

    if (id == 1) {
        let et = {
            "eventId": 1,
            "name": "university course",
            "percentCovered": 80.0
        };
        return et;
    }
    else if (id == 2) {
        let et = {
            "eventId": 2,
            "name": "seminars",
            "percentCovered": 60.0
        };
        return et;
    }
    else if (id == 3) {
        let et = {
            "eventId": 3,
            "name": "certification preperation classes",
            "percentCovered": 75.0
        };
        return et;
    }
    else if (id == 4) {
        let et = {
            "eventId": 4,
            "name": "certification",
            "percentCovered": 100.0
        };
        return et;
    }
    else if (id == 5) {
        let et = {
            "eventId": 5,
            "name": "technical training",
            "percentCovered": 90.0
        };
        return et;
    }
    else {
        let et = {
            "eventId": 6,
            "name": "other",
            "percentCovered": 30.0
        };
        return et;
    }
   
}

function getGradingFormatID(id) {

    if (id == 1) {
        let gf = {
            "formatId": 1,
            "name": "Grade",
            "example": "75"
        };
        return gf;
    }
    else if (id == 2) {
        let gf = {
            "formatId": 2,
            "name": "Pass/Fail",
            "example": "Pass/Fail"
        };
        return gf;
    }
    else if (id == 3) {
        let gf = {
            "formatId": 3,
            "name": "Presentation",
            "example": "Presented"
        };
        return gf;
    }
    else {
        let gf = {
            "formatId": 4,
            "name": "Other",
            "example": "Other"
        };
        return gf;
    }

    
}
async function createRequestJSON() {

    /** 
     must be model as following
     {
        "requestor": {
            "empId": 2,
            "firstName": "Richard",
            "lastName": "Duenas",
            "username": "ricky23i",
            "password": "pass123",
            "role": {
                "name": "employee",
                "roleId": 1
            },
            "funds": 1000.0,
            "supervisor": {
                "empId": 3,
                "firstName": "Eng",
                "lastName": "Sup",
                "username": "engsup",
                "password": "super123",
                "role": {
                "name": "direct supervisor",
                "roleId": 2
            },
                "funds": 800,
                "supervisor": 3,
                "department": {
                "deptId": 1,
                "name": "Engineers",
                "deptHeadId": 4
            }
            },
            "department": {
                "deptId": 1,
                "name": "Engineers",
                "deptHeadId": 4
            }
        },
        "eventDate": "2022-02-28",
        "eventTime": "09:44:03",
        "location": "remote",
        "description": "pikachu",
        "cost": 500.0,
        "gradingFormat": {
            "formatId": 1,
            "name": "Grade",
            "example": "75"
        },
        "eventType": {
            "eventId": 1,
            "name": "university course",
            "percentCovered": 80.0
        },
        "status": {
            "statusId": 1,
            "name": "pending approval",
            "approver": "direct supervisor"
        },
        "submittedAt": ""
}     */

    let req = await getEmployByID(document.getElementById("id").value);
    let et = getEventTypeID(document.getElementById("event").value);
    let st = {
        "statusId": 1,
        "name": "pending approval",
        "approver": "direct supervisor"
    };
    let gf = getGradingFormatID(document.getElementById("gformat").value)
    let edate = document.getElementById("event-date").value;
    let etime = String(document.getElementById("event-time").value);
    etime = etime + ":01";
    let l = document.getElementById("loca").value;
    let d = document.getElementById("desc").value;
    let c = document.getElementById("cost").value;
    let dt = new Date();
    dt = dt.getDate;
    console.log(etime);
    //console.log(st);
    //console.log(gf);
    let request = {
        "requestor": req,
        "eventDate": edate,
        "eventTime": etime,
        "location": l,
        "description": d,
        "cost": c,
        "gradingFormat": gf,
        "eventType": et,
        "status":st,
        "submittedAt": dt
    };
    //console.log(request);
    
    let response = await fetch(trmsAppUrl + 'requests', {
        method: 'POST',
        body: JSON.stringify(request),
    });
    if (response.status === 201) {
        alert("Request has been sent");
    }
    else
        alert("Something went wrong");
        
}


