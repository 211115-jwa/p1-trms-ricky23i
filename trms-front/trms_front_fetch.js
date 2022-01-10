


async function getPendingRequestByID() {

    let response = await fetch(trmsAppUrl + 'requests/manage/' + document.getElementById('empid').value);
    if (response.status === 200) {
        let requests = await response.json();
        console.log(requests);
        if (requests.length == 0)
            alert('No pending requests found');
        showPendingRequests(requests);
    }
    else
        alert('something went wrong')
}


function showPendingRequests(requests) {
    let requestTable = document.getElementById('requestsID');
    for (var i = requestTable.rows.length - 1; i > 0; i--) {
        requestTable.deleteRow(i);
    }
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
    alert("results");
}
async function getRequestByID() {
   
    let response = await fetch(trmsAppUrl + 'requests/requestor/' + document.getElementById('empid').value);
    if (response.status === 200) {
        let requests = await response.json();
        console.log(requests);
        if (requests.length == 0)
            alert('No requests found');
        showRequests(requests);
    }
    else
        alert('something went wrong')
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
    alert("results")
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

function getStatus(sname,approver) {
    /*
     preset objects for status could of can another fetch get but would take too much time to implement.
     */
    let stat;
    if (sname === "pending approval") {
        if (approver === "direct supervisor")
            stat = {
                "statusId": 1,
                "name": "pending approval",
                "approver": "direct supervisor"
            };
        if (approver === "department head")
            stat = {
                "statusId": 4,
                "name": "pending approval",
                "approver": "department head"
            };
        if (approver === "benefits coordinator")
            stat = {
                "statusId": 7,
                "name": "pending approval",
                "approver": "benefits coordinator"
            };

    }
    else if (sname === "approved") {
        if (approver === "direct supervisor")
            stat = {
                "statusId":2,
                "name": "approved",
                "approver": "direct supervisor"
            };
        if (approver === "department head")
            stat = {
                "statusId": 5,
                "name": "approved",
                "approver": "department head"
            };
        if (approver === "benefits coordinator")
            stat = {
                "statusId": 8,
                "name": "approved",
                "approver": "benefits coordinator"
            };

    }
    else if (sname === "denied") {
        if (approver === "direct supervisor")
            stat = {
                "statusId": 3,
                "name": "denied",
                "approver": "direct supervisor"
            };
        if (approver === "department head")
            stat = {
                "statusId": 6,
                "name": "denied",
                "approver": "department head"
            };
        if (approver === "benefits coordinator")
            stat = {
                "statusId": 9,
                "name": "denied",
                "approver": "benefits coordinator"
            };

    }
    return stat;
}

function getEventTypeID(id) {
    /*
     preset objects for et could of can another fetch get but would take too much time to implement.
     */
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
    /*
     preset objects for gf could of can another fetch get but would take too much time to implement.
     */
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
     must be modeled as following
     {
        "requestor": employee object, retrieved from database by emp id
        "eventDate": date , from form
        "eventTime": time in hh:mm:ss format, from form
        "location": location, from form
        "description": desc, from form
        "cost": cost, from form
        "gradingFormat": gf object, function that has predetermined objects (lazy way to save time)
        "eventType": et object, function that has predetermined objects (lazy way to save time)
        "status": Stat object,function we are submitting so they will be put in the automatic pending since no upload document will be emplemented
        "submittedAt": current date 
}     */

    let req = await getEmployByID(document.getElementById("id").value);
    let et = getEventTypeID(document.getElementById("event").value);
    let st = getStatus("pending approval", "direct supervisor");
    let gf = getGradingFormatID(document.getElementById("gformat").value)
    let edate = document.getElementById("event-date").value;
    let etime = String(document.getElementById("event-time").value);
    /*
     format needs to be 00:00:01
     getting formatting error if left at 00 seconds
     javascript input type time gives back 00:00 format for anything not 12am if its 12am it sends back 00:00:00
     */
    if (etime==="00:00:00") {
        etime = "00:00:01";
    }
    else {
        etime = etime + ":01";
    }
    console.log(etime.length);
    console.log(etime);
    let l = document.getElementById("loca").value;
    let d = document.getElementById("desc").value;
    let c = document.getElementById("cost").value;
    let dt = new Date();
    dt = dt.getDate;
    //console.log(etime);
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


async function denyRequest() {
    let stat = getStatus("denied", document.getElementById("role").value);
    let response = await fetch(trmsAppUrl + 'requests/requestor/deny/' + document.getElementById('reqid').value, {
        method: 'Put',
        body: JSON.stringify(stat),
    });
    if (response.status === 202)
        alert('Denied');
    if (response.status === 406)
        alert('No requests found make sure id is a number');


}

async function approveRequest() {
    let stat = getStatus("approved", document.getElementById("role").value)
    console.log(stat);
    let response = await fetch(trmsAppUrl + 'requests/requestor/approve/' + document.getElementById('reqid').value, {
        method: 'Put',
        body: JSON.stringify(stat),
    });
    if (response.status === 202)
        alert('Approved');
    if (response.status === 406)
        alert('No requests found make sure id is a number');

    
}
