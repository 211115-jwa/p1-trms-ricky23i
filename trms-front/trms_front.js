let trmsAppUrl = 'http://localhost:8080/';
setupNav();
function setupNav() {
    let nav = document.getElementById('nav');
      nav.innerHTML = `<span id="navLeft">
        <a href="trms_front.html"><b>Tuition Reimbursement Form</b></a>
        <a href="request.html"><b> Requests</b></a>
        </span>
        <span id="navRight">
        <a href="request_rewiew.html"><b>Requests Management</b></a>
        </span>`;
    }


function submitReq() {
    console.log('Submit')
}
function viewReimb() {
    console.log("Viewall")
}