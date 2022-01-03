let trmsAppUrl = 'http://localhost:8080/';
setupNav();
function setupNav() {
    let nav = document.getElementById('nav');
      nav.innerHTML = `<span id="navLeft">
        <a href="trms_front.html"><b>Tuition Reimbursement Form</b></a>
        <a href="request.html"><b>Pending Requests</b></a>
        </span>
        <span id="navRight">
        <a href="#">Log In</a>
        </span>`;
    }


function submitReq() {
    console.log('Submit')
}
function viewReimb() {
    console.log("Viewall")
}